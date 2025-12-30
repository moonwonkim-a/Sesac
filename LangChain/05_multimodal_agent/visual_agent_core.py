import os
from dotenv import load_dotenv
from langchain_openai import ChatOpenAI
from langchain_core.messages import HumanMessage
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_community.tools import DuckDuckGoSearchRun

# 환경 변수 로드
load_dotenv()

class TravelAgent:
    """
    이미지를 분석하고 여행 정보를 제공하는 멀티모달 에이전트 클래스
    """

    def __init__(self):
        self.vision_model = ChatOpenAI(model='gpt-4o',temperature=0)
        
        self.chat_model = ChatOpenAI(model='gpt-5-nano',temperature=1)

        self.search_tool = DuckDuckGoSearchRun()

        

    # 장소 식별 함수
    def identify_landmark(self, img_url):       # 파이썬에서의 class 내부 메소드는 무조건 self를 인자로 가지고 있어야 함
        """ 1단계 : 이미지 식별 - 사진을 보고 장소 이름을 반환 """

        model = ChatOpenAI(model='gpt-4o', temperature=0)

        prompt = "이 사진속 장소의 정확한 이름만 알려줘. 다른말은 하지 말고"

        message = HumanMessage(
            content = [
                {'type':'text', 'text' : prompt},
                {'type':'image_url', 'image_url':{"url":img_url}}
            ]
        )

        response = self.vision_model.invoke([message])
        place_name = response.content.strip()

        print(f"식별된 장소 : {place_name}")
        return place_name
    
    def search_info(self, place_name):
        """ 장소 이름으로 여행 정보 검색 """
        query = f"{place_name} tourism interesting facts entry fee"

        try:
            result = self.search_tool.invoke(query)
            return result
        except Exception as e:
            return f"검색중 오류 발생 : {e}"
    
    def generate_guide(self, place_name, search_results):
        """ 검색된 정보를 바탕으로 여행 가이드 텍스트 생성 """
        prompt = ChatPromptTemplate.from_template("""
        넌 유럽국가의 여행 전문 가이드야. 아래 정보를 바탕으로 '{place_name}' 에 대한 흥미로운 여행 가이드를 한국어로 작성해줘.

        [검색된 정보]
        {info}

        [가이드 포함 내용]
        1. 장소 소개 및 역사
        2. 사용 언어
        3. 관광 요소(즐길거리, 장소 등등)
        4. 방문 팁

        톤 앤 매너 : 친절하고 흥미진진하게. 이모지 사용해도돼.
        """)

        chain = prompt | self.chat_model | StrOutputParser()
        return chain.invoke({'place_name': place_name, 'info': search_results})

    def run(self, image_url):
        """ 실행 메인 파이프라인 """
        
        # 1. 이미지 식별
        place_name = self.identify_landmark(image_url)
        # 2. 검색
        info = self.search_info(place_name)
        # 3. 텍스트 생성
        guide_text = self.generate_guide(place_name, info)

        return {
            'place' : place_name,
            'guide' : guide_text
        }