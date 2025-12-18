import json

structured_data = [
    {
        "id" : 1,
        "category" : "python",
        "question" : "파이썬의 장점",
        "answer" : "간결한 문법과 강력한 라이브러리 생태계",
        "tags" : ["python", "programming", "strength"]
    },
    {
        "id" : 2,
        "category" : "python",
        "question" : "리스트와 튜플의 차이",
        "answer" : "리스트는 가변(mutable), 튜플은 불변(immutable)",
        "tags" : ["list", "tuple", "data_structure"]
    }
]

output_filename = 'structured_data.json'

# 파이썬 객체를 JSON 파일로 저장하기
print(f"'{output_filename}' 파일로 데이터를 저장중 ...")
try:
    # 파일을 'w'(쓰기)모드로 연다. with 구문은 파일을 안전하게 열고 자동으로 닫아준다.
    with open(output_filename,"w",encoding='utf-8') as f:
        # json.dump()를 사용해 데이터를 파일에 쓴다.
        # 1. data : 저장할 파이썬 객체
        # 2. f : 데이터를 쓸 파일 객체
        # 3. indent=2 : 사람이 보기 좋게 2칸 들여쓰기 (가독성을 위해 매우 중요)
        # 4. ensure_ascii=False : 한글을 유니코드로 변환하지 않고 원본 그대로 저장(필수)
        json.dump(structured_data, f, indent=2, ensure_ascii=False)

    print("파일 저장이 성공적으로 완료되었습니다.")
    
except Exception as e :
    print(f"파일 저장 중 오류 발생: {e}")


# JSON 파일을 다시 파이썬 객체로 불러오기
print(f"{output_filename} 파일을 다시 읽어오는 중...")
try:
    # 파일을 'r'(읽기) 모드로 연다.
    with open(output_filename, 'r', encoding='utf-8') as f:
        # load()는 파일 객체를 받아, json 문자열을 파싱하여 해당하는 파이썬 객체로 변환해준다.
        loaded_data = json.load(f)

    print("파일 읽기 성공")
    print("불러온 데이터의 타입 : ", type(loaded_data))
    print(loaded_data[0]["question"])
    print(loaded_data[0]["answer"])

except FileNotFoundError :
    print(f"{output_filename} 파일을 찾을 수 없습니다.")
# JSON 형식 자체가 잘못되었을 때
except json.JSONDecodeError:
    print(f"{output_filename} 파일이 올바른 JSON 형식이 아닙니다.")
except Exception as e:
    print(f"파일 읽기 중 오류 발생 : {e}")


# JSON 문자열과 파이썬 객체 변환

# 파이썬 딕셔너리 -> JSON 문자열로 변화
my_dict = {"name" : "GOD", "power" : 100}
json_string = json.dumps(my_dict, indent=2, ensure_ascii=False)
print(json_string)
print(type(json_string))

# JSON 문자열 -> 파이썬 딕셔너리로 변환
retrieved_string = '{"id" : "user1", "isActive" : true}'
retrieved_dict = json.loads(retrieved_string)
print(retrieved_dict)
print(type(retrieved_dict))
print(retrieved_dict['isActive'])