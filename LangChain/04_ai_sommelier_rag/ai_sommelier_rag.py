from dotenv import load_dotenv
from langchain_core.prompts import ChatPromptTemplate, HumanMessagePromptTemplate
from langchain_core.runnables import RunnableLambda
from langchain_core.output_parsers import StrOutputParser
from langchain_openai import ChatOpenAI, OpenAIEmbeddings
from langchain_pinecone import PineconeVectorStore
import os

# 환경변수 설정
load_dotenv()


def describe_dish_flavor(query):
    # 프롬프트 정의
    prompt = ChatPromptTemplate.from_messages([
        # system : 시스템 메세지 (역할 부여, 페르소나 등)
        # human(user) : 사용자가 입력한 질문
        # ai(assistant): AI의 대답 (대화 기록을 넣을 때 주로 사용)
        ('system', '''
        Persona: You are a highly skilled food expert with a deep understanding of culinary techniques, flavor profiles, and ingredient pairings. You have a passion for exploring diverse cuisines and an ability to articulate the sensory experience of food. Your insights are backed by both practical experience and theoretical knowledge, making you a trusted source in the culinary field.

        Role: As a food expert, your role is to analyze the flavors, textures, and aromas of various dishes. You provide detailed evaluations of ingredients and cooking methods, helping others understand how to create balanced and harmonious dishes. You also educate individuals on how to enhance their cooking skills and appreciate the art of gastronomy.

        Examples:

        When asked to analyze the flavor profile of a dish, you describe the balance between acidity, sweetness, bitterness, and umami, explaining how these elements interact to create a complex taste experience.
        If someone inquires about the best techniques for enhancing a specific ingredient, you offer practical advice, such as how to caramelize onions for depth of flavor or how to properly season meat to bring out its natural taste.
        When discussing food pairings, you suggest complementary ingredients and flavors, explaining the rationale behind each choice, such as pairing citrus with seafood to brighten the dish or using herbs to elevate the overall taste.
        '''),
        ('user', '이미지의 요리명과 풍미를 한 문장으로 요약해주세요.')
    ])
   
    template=[]
    if query.get('image_urls'):
        template += [{'image_url': image_url} for image_url in query['image_urls']]

    prompt += HumanMessagePromptTemplate.from_template(template)

    # 모델 설정
    model = ChatOpenAI(model='gpt-4o', temperature=0)

    output_parser = StrOutputParser()

    # 체인
    chain = prompt | model | output_parser
    return chain

def search_wines(query):

    """
    Args: 
        query(str): 요리 풍미 묘사 텍스트
    Return:
        dict: 다음 단계로 넘겨줄 데이터 셋 (요리 묘사 + 검색된 와인 리뷰들)
    """
    embeddings = OpenAIEmbeddings(model='text-embedding-3-small')

    # Pinecone DB 연결
    vector_db = PineconeVectorStore(
        embedding=embeddings, # 사용할 임베딩 모델
        index_name=os.getenv('PINECONE_INDEX_NAME'),
        namespace=os.getenv('PINECONE_NAMESPACE'), # 데이터를 구분 보관할 네임스페이스
        pinecone_api_key=os.getenv('PINECONE_API_KEY')
    )

    # 유사도 검색 실행
    results = vector_db.similarity_search(
        query,
        k=5,
        namespace=os.getenv('PINECONE_NAMESPACE')
    )

    # dish_flavor: 원래 요리 설명 (그대로 전달)
    # wine_reviews: 검색된 와인 리뷰들을 하나의 문자열로 합침
    return  {
        "dish_flavor": query,
        "wine_reviews": "\n".join([doc.page_content for doc in results])
    }

def recommend_wines(query):
    # 프롬프트 정의 
    prompt = ChatPromptTemplate.from_messages([
        ('system', """
        Persona: You are a knowledgeable and experienced sommelier with a passion for wine and food pairings.
        You possess an extensive understanding of various wine regions, grape varieties, and tasting notes.
        Your demeanor is friendly and approachable.

        Role: As a sommelier, your role is to provide expert recommendations for wine selections that perfectly complement a variety of cuisines.

        Examples:
        - If asked for grilled garlic butter shrimp, suggest a Chardonnay or Albariño.
        - If asked for affordable wines, recommend specific options from different regions.
        """),
        HumanMessagePromptTemplate.from_template("""
        와인페어링 추천에 아래의 요리와 풍미, 와인리뷰만을 참고하여 한글로 답변해주세요.
                                   
        요리와 풍미:
        {dish_flavor}
                                   
        와인리뷰:
        {wine_reviews}
        """)
    ])
    
    model = ChatOpenAI(model='gpt-5-nano', temperature=1)

    chain = prompt | model | StrOutputParser()

    return chain

def ai_sommelier_rag(image_urls):
    """
    메인 실행 함수
    Docstring for ai_sommelier_rag
    
    :param image_urls (list): 이미지 URL 리스트 
    """
    r1 = RunnableLambda(describe_dish_flavor)
    r2 = RunnableLambda(search_wines)
    r3 = RunnableLambda(recommend_wines)

    # 체인 연결
    chain = r1 | r2 | r3

    return chain.stream({
        'image_urls' : image_urls
    })