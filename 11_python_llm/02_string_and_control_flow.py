# 문자열 핵심 기능
# 슬라이싱 : 문자열의 일부를 잘라낸다. [시작인덱스:끝인덱스]
# 끝 인덱스는 포함되지 않는다. 

text = "hello world"
print(f"슬라이싱[0:5] : {text[:5]}")    # 시작인덱스를 생략하면 0번 인덱스부터 (0인덱스부터 5인덱스 전까지의 문자열)
print(text[6:])     # 끝 인덱스를 생략하면 시작인덱스부터 문자열 끝까지
print(text[:])      # 처음부터 끝까지
print(text[::-1])   # [::step] step의 수 만큼 건너 뛰면서 값을 가져옴 // step을 음수로 주변 뒤에서부터 값을 가져옴

# split() : 긴 텍스트를 문장 단위로 나누거나, CSV 데이터를 콤마(,)기준으로 나눌 때 많이 사용
# 문자열을 특정 기준으로 나눠 리스트로 만든다.
csv_data = "문,22,서울"
user_list = csv_data.split(',')
print(f"split 결과 : {user_list}")

# 제어문 : if, for
score = 85

# 파이썬은 중괄호 대신 들여쓰기로 코드 블록을 구분한다.
# if문이나 for문 선언 끝에 콜론(:)을 찍고, 그 다음줄에 들여쓰기 된 부분 전체가 하나의 코드 블럭으로 인식된다.
if score >= 90:
    grade = 'A'
elif score >= 80:
    grade = 'B'
else :
    grade = 'F'
print(f"점수 : {score}, 등급 : {grade}")

foods = ['버거', '파스타', '스테이크', '감바스']
for food in foods:
    print(f"오늘의 메뉴 : {food}")


user_info = {'name' : 'moon', 'age' : '5000'}
# .keys() : key값을 가져온다.
# .values() : value 값을 가져온다.
# .items() : key와 value를 한 쌍으로 가져온다.
for key, value in user_info.items():
    print(f"- {key} : {value}")

