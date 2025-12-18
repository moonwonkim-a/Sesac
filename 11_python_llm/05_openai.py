from openai import OpenAI
import os
from dotenv import load_dotenv

load_dotenv()

api_key = os.getenv("OPEN_API_KEY")

client = OpenAI(api_key=api_key)

response = client.chat.completions.create(
    model = "gpt-4o",
    messages=[
        {"role": "user", "content": "파이썬 SDK에 대해 50자 이내로 설명해줘"}
    ],
    temperature=1.0
)

sdk_answer = response.choices[0].message.content    # 객체 기반으로 접근
print(sdk_answer)