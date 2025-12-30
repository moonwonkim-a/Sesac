import streamlit as st
from PIL import Image
import requests
from io import BytesIO
from ai_sommelier_rag import ai_sommelier_rag

st.title("🍷AI Wine Sommelier🍾")
st.write("🍖음식 이미지 URL을 작성하면, 어울리는 와인🍷을 추천해드립니다.")

# 사용자 입력 폼
with st.form(key='img_form'):
    img_url = st.text_input("이미지 URL 입력:", placeholder="예: https://example.com/food.jpg")
    submit_button = st.form_submit_button(label="제출(Submit)")

# 결과 처리 및 출력
if submit_button:
    if img_url:
        try:
            # URL에서 이미지 다운로드 및 화면 표시
            response = requests.get(img_url)
            response.raise_for_status # URL 에러 체크
            image = Image.open(BytesIO(response.content))

            st.image(image) # 이미지 출력

            # AI 메세지 출력
            st.subheader("AI 와인 추천:")

            with st.spinner("와인 검색중..."):
                
                # 우리가 만든 함수 호출
                response_stream = ai_sommelier_rag([img_url])

                # langchain의 stream 반환값과 호환된다
                st.write_stream(response_stream)    # 타자기처럼 글자가 한 글자씩 써지는 효과

        except Exception as e:
            st.error(f"이미지를 로드하는 중 오류가 발생했습니다 : {e}")
    else:
        st.warning("이미지 URL을 입력해주세요.")