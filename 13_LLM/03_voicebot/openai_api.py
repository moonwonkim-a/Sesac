from openai import OpenAI
import base64
from dotenv import load_dotenv
import os

load_dotenv()

client = OpenAI()

# STT 함수 구현 
def stt(audio): 
    filename = 'temp.mp3'       # 오디오 데이터 저장할 임시 파일명
    audio.export(filename, format='mp3')

    with open(filename, 'rb') as f:
        transcription = client.audio.transcriptions.create(
            model = 'whisper-1',
            file = f            
        )
    os.remove(filename)     # 용건이 끝난 임시 파일 삭제
    return transcription.text

# 대화 내역 전체(messages) 를 받아 답을 주는 함수 
def ask_gpt(messages, model):
    response = client.chat.completions.create(
        model = model,
        messages = messages,
        temperature = 1,
        max_completion_tokens = 4096
    )
    return response.choices[0].message.content

# TTS 함수 구현
def tts(text):
    filename='output.mp3'
    with client.audio.speech.with_streaming_response.create(
        model="tts-1",
        voice='nova',
        input=text
    ) as response:
        response.stream_to_file(filename)

    # base64 인코딩
    with open(filename, 'rb') as f:
        data = f.read()
        b64_encoded = base64.b64encode(data).decode()
        # HTML 오디오 태그 생성 (자동 재생)
        audio_tag = f"""
        <audio autoplay="true">
            <source src="data:audio/mp3;base64,{b64_encoded}" type='audio/mp3'/>
        </audio>
        """

    os.remove(filename)

    return audio_tag    # 파일이 아닌 오디오 정보가 담긴 HTML 코드 조각 반환