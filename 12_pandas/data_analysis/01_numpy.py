import numpy as np

# Numpy : 파이썬에서 숫자 데이터(배열)을 빠르고 편하게 다루기 위한 라이브러리

# python 리스트
prices_list = [1000,2000,3000]
# pirces_list + 100
new_list = [price + 100 for price in prices_list]
print(new_list)

# Numpy 배열
prices_array = np.array([1000, 2000, 3000])
new_prices = prices_array + 100     # for문 없이 모든 데이터에 100원을 더함 -> 백터화
print(f"오른 가격 : {new_prices}")

# Shape (데이터의 모양)
data = np.array([
    [1,2,3],
    [4,5,6]
])

print(data.shape)   # (2,3) -> 2행 3열
print(data.dtype)

# LLM과의 연결고리 (임베딩)
embedding_vetor = np.random.rand(5) # 0 ~ 1 사이의 랜덤 실수 5개
print(f"임베딩 벡터 예시 : {embedding_vetor}")