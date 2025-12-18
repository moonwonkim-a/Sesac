# 파이썬으로 HTTP 요청을 쉽게 보낼 수 있게 해주는 라이브러리
import requests
# 운영체제와 상호작용하는 기능을 제공하는 내장 모듈 (환경변수 접근 등등)
import os
#dotenv : .env 파일에 정의된 변수를 환경 변수로 로드해주는 라이브러리
from dotenv import load_dotenv

# 환경 변수 로드
# 이 스크립트와 같은 폴더나 상위 폴더에 있는 .env 파일을 찾아 안의 내용을 시스템 환경변수처럼 쓸 수 있게 메모리에 올려줌
load_dotenv()

# API키 안전하게 불러오기
api_key = os.getenv("OPENAI_API_KEY")

if not api_key:
    raise ValueError("OPENAI_API_KEY 환경 변수가 설정되지 않았습니다.")

# API 요청 정보 설정
api_url = "https://api.openai.com/v1/chat/completions"

headers = {
    "Authorization" : f"Bearer {api_key}",
    "Content-Type": "application/json"
}

data = {
    "model" : "gpt-4o", # 사용할 LLM 모델
    "messages" : [
        {"role" : "user", "content" : "사람의 뉴런 신경망에 대해 설명해줘."}
    ],
    "temperature" : 0.7 # 답변의 창의성을 조절하는 값(0~2) // 모델마다 범위가 다름
}

# API 요청 보내기 및 응답 처리
try:
    # API에 POST 요청을 보낸다.
    # json=data 옵션은 딕셔너리를 JSON문자열로 변환하고, 헤더에 맞게 전송해준다.
    response = requests.post(api_url, headers=headers, json=data)

    # .json() 메소드는 응답받은 JSON 문자열을 파이썬 딕셔너리로 변환해준다.
    result = response.json()

    import json
    print(json.dumps(result, indent=2, ensure_ascii=False))

    answer = result['choices'][0]['message']['content']
    print(f" LLM 답변 : {answer}")

except requests.exceptions.RequestException as e:
    print(f"API 요청 중 오류 발생 : {e}")