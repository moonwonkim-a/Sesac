# 1. 기본 함수와 Type Hint
def create_greeting(name : str, age : int = 20) -> str : 
    """이 함수는 이름과 나이를 받아 인사말을 생성합니다. """    # docstring : 함수 설명문
    return f"Hi, {age}살(세) {name} 님."

# 여러가지 함수 호출 방법
print(create_greeting("moon", 299999))  # 기본적인 호출 방법
print(create_greeting(age = 333333, name = "sun"))  # 키워드 인자는 순서가 바뀌어도 된다. (매개변수의 순서를 맞출 필요 없이 키워드 인자로 값을 지정해줘도 됨)
print(create_greeting("star"))  # age에 기본값 20을 지정했기 때문에 값을 넣지 않아도 출력됨

# 2. 가변인자(*args)와 키워드 가변 인자(**kwargs)
# *args는 몇개가 들어올 줄 모르는 인자들을 튜플로 받는다.
# 튜플 : '값을 바꿀수 없는 리스트' (* 하나는 튜플로 받는다고 생각)
# **kwargs는 키워드 인자들을 딕셔너리로 받는다. (* 두개는 딕셔너리로 받는다고 생각)
def call_llm_api(prompt : str, *args, **kwargs):
    """가상의 LLM API 호출 함수"""
    print(f"전송할 프롬프트 : '{prompt}'")
    if args:
        print(f"부가 옵션(tuple): {args}")
    if kwargs:
        print(f"상세 설정(dict): {kwargs}")

call_llm_api(
    "오늘 점심 추천해줘",   # prompt
    "3줄 요약",             # *args 에 들어감 (여러개라면 튜플로 묶여서 같이 출력됨)
    model = "gpt-4o",       # **kwargs에 들어감
    temperature = 0.7       # **kwargs에 들어감
)