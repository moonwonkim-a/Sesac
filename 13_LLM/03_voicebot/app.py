import streamlit as st
from audiorecorder import audiorecorder
from streamlit_chat import message as msg
import openai_api

st.set_page_config(layout='wide')
st.header('🎙Voice Chatbot🎙')

# Session state 초기화
if 'messages' not in st.session_state :
    st.session_state['messages'] = [
        {"role" : "system", "content" : "넌 싸가지없는 직장 상사야"}
    ]

# 초기화 플래그(녹음 후 화면 리셋 방지용)
if 'check_reset' not in st.session_state:
    st.session_state['check_reset'] = False

# 사이드바 구성
with st.sidebar:
    model=st.radio('모델 선택', ['gpt-3.5-turbo','gpt-5-nano'])
    if st.button('초기화'):
        st.session_state['messages'] = [{'role' : 'system', 'content' : '...'}]
        st.session_state['check_reset'] = True

# 레이아웃 구성
col1, col2 = st.columns(2)

with col1:
    st.subheader("녹음하기")
    audio = audiorecorder()

    # 녹음 데이터가 있고, 리셋 상태가 아닐 때 실행
    if(audio.duration_seconds > 0) and (not st.session_state['check_reset']):
        # 사용자 음성 재생
        st.audio(audio.export().read())

        # STT
        query = openai_api.stt(audio)
        st.session_state['messages'].append({'role' : 'user', 'content' : query})

        # GPT
        response = openai_api.ask_gpt(st.session_state['messages'], model)
        st.session_state['messages'].append({'role':'assistant', 'content':response})

        # TTS
        audio_tag = openai_api.tts(response)
        st.html(audio_tag)