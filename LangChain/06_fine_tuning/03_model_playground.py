import streamlit as st
import os
from dotenv import load_dotenv
from openai import OpenAI

load_dotenv()

client = OpenAI()

st.set_page_config(page_title='Fine-Tuning Playground', page_icon='🛰')

st.title("Fine-Tuning Playground")
st.markdown("내가 만든 **커스텀 모델(fine-tuning)**과 **기본 모델(Base)**의 말투 비교")

# 사이드바 : 모델 설정
with st.sidebar:
    st.header("모델 설정")

    # Base Model
    base_model = st.text_input("Base Model ID", value='gpt-4o-mini-2024-07-18')

    # Fine-tuned Model
    ft_model = st.text_input("Fine-tuned Model ID",help="학습 완료 후 받은 모델 ID를 입력하세요.")

    systme_prompt = st.text_area("시스템 프롬프트", value="너는 트렌디하고 친절한 인스타 마케터 봇이야.")

# 채팅 기록 세션 초기화
if "messages" not in st.session_state:
    st.session_state.messages = []

for message in st.session_state.messages:
    with st.chat_message(message['role']):
        st.markdown(message['content'])

# 사용자 입력 처리
# :=(월러스 연산자) : 입력값이 None이 아니면 if문 실행
if prompt := st.chat_input("질문을 입력하세요 ex) 2026 패션 트랜드 알려줘"):    

    # 사용자 질문을 화면에 표시
    st.session_state.messages.append({'role':'user','content':prompt})
    with st.chat_message('user'):
        st.markdown(prompt)

    col1, col2 = st.columns(2)

    with col1:
        st.subheader("Base Model")
        with st.spinner("생성 중...."):
            try:
                response_base = client.chat.completions.create(
                    model=base_model,
                    messages=[
                        {'role':'system','content':systme_prompt},
                        {'role':'user','content':prompt}
                    ],
                    temperature=0.8
                )
                base_replay = response_base.choices[0].message.content
                st.info(base_replay)
            except Exception as e:
                st.error(f"Error: {e}")
    
    with col2:
        st.subheader("Fine-tuned Model")
        with st.spinner("생성 중...."):
            try:
                response_ft = client.chat.completions.create(
                    model=ft_model,
                    messages=[
                        {'role':'system','content':systme_prompt},
                        {'role':'user','content':prompt}
                    ],
                    temperature=0.8
                )
                ft_replay = response_ft.choices[0].message.content
                st.success(ft_replay)

                st.session_state.messages.append({'role':'assistant','content': ft_replay})
            except Exception as e:
                st.error(f"Error: {e}")