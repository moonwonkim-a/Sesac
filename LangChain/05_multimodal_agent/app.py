import streamlit as st
import requests
from PIL import Image
from io import BytesIO
import base64
from visual_agent_core import TravelAgent   # 만든 클래스를 임포트


st.set_page_config(page_title="AI로 떠나는 여행", page_icon="✈")
st.title("AI로 떠나는 여행")
st.markdown("여행 사진을 올리면, **AI가 장소를 식별하고 여행 가이드를 만들어 드립니다.**")

# 에이전트 초기화(Session state 사용)
if "agent" not in st.session_state:
    st.session_state['agent'] = TravelAgent()

tab1, tab2 = st.tabs(["이미지 URL 입력", "파일 업로드"])

with tab1:
    url_input = st.text_input("이미지 URL을 넣어주세요 : ", placeholder="https://example....")
    if url_input:
        image_source = url_input
        try:
            headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36'}
            response = requests.get(url_input,headers=headers, stream=True)
            image_data = Image.open(BytesIO(response.content))
            st.image(image_data)
        except:
            st.error("이미지를 불러올 수 없습니다.")

with tab2:
    file_input = st.file_uploader("이미지 파일을 업로드하세요.", type=['jpg','png','jpeg'])
    if file_input:
        image_data = Image.open(file_input)
        st.image(image_data)
        
        # 파일의 바이트 데이터를 읽어온다.
        raw_data = file_input.getvalue()
        # base64로 인코딩
        base64_data = base64.b64encode(raw_data).decode('utf-8')

        # Data URI 형식으로 
        mime_type = file_input.type
        image_source = f"data:{mime_type};base64,{base64_data}"

if st.button("여행 가이드 불러오기"): 
    if not image_source:
        st.warning("이미지를 먼저 입력해주세요.")
    else:
        with st.spinner("AI 분석중...."):
            try:
                # 에이전트 실행
                result = st.session_state['agent'].run(image_source)

                st.success("완료!")

                st.subheader(f"식별된 장소 : {result['place']}")
                st.markdown(result['guide'])

            except Exception as e:
                st.error(f"오류가 발생했습니다. {e}")