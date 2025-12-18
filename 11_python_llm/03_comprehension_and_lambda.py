# List Comprehension : 한 줄 for문

# 기본 구조 : [(결과) for (변수) in (반복대상)]
# 1부터 10까지 제곱수로 이루어진 리스트 만들기
# range(1,11) = 1부터 10까지(11 미만) 연속된 숫자를 만들어주는 함수
squares = [n**2 for n in range(1, 11)]
print(f"제곱수 리스트 : {squares}")

# 5글자 이상인 과일만 필터링해서 대문자로 바꾸기
fruits = ['orange', 'apple', 'banana', 'watermelon', 'kiwi']
long_fruits = [fruit.upper() for fruit in fruits if len(fruit) >= 5]
print(f"긴 이름 과일(대문자) : {long_fruits}")

# Dict comprehension
# {(key) : (value) for (변수) in (리스트)}
student_names = ['moon', 'sun', 'star']
# 이름 : 이름길이 로 구성된 딕셔너리 만들기
name_lengths = {name: len(name) for name in student_names}
print(f"이름 길이 : {name_lengths}")

# lambda : 이름 없는 한 줄 짜리 익명 함수 (lambda 매개변수 : 리턴값)
add = lambda a, b: a + b
print(f"결과 : {add(10, 20)}")

students = [
    {'name' : 'moon', 'score' : 90}, 
    {'name' : 'sun', 'score' : 100}, 
    {'name' : 'star', 'score' : 50}, 
]

# students의 각 요소(딕셔너리)를 s라는 이름으로 하나씩 받고,
# 그 s에서 'score' 키의 값을 뽑아 리턴하겠다 라는 뜻
# 최종적으로 람다 함수가 리턴 해주는 score값을 보고 순서 정렬
students.sort(key=lambda s: s['score'], reverse=True) # 내림차순 정렬
print(f"성적순 정렬 : {students}")