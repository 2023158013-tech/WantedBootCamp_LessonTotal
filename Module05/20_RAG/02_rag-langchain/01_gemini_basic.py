# .env를 로컬 파일에서 읽기 위한 os import(운영체제에 접근할 수 있는 라이브러리)
import os

# .env 환경 변수 읽어들이기
from dotenv import load_dotenv
# google 생태계 라이브러리 중 gemini 활용
from google import genai
# types: gemini 호출 시 system prompt 등을 설정할 수 있음.
from google.genai import types

# 현재 폴더의 .env를 읽을 준비
load_dotenv()

# api_key
# 주의점: api_key가 없거나, 만료되었을 때 Exception 처리가 필수적이다.
api_key = os.getenv("GOOGLE_API_KEY")

# google ai 객체 생성
# 해당 객체를 통해서 모든 요청을 보낸다.
client = genai.Client(api_key=api_key)

# flash: 빠르고 저렴하다.
# pro: 더 똑똑하지만 flash보다 느리고 호출 비용이 더 비싸다.
MODEL = "gemini-3.5-flash"

# 기본 호출
# print("======기본 호출======")
# # generate_content(): 해당 함수는 응답이 완성될 때까지 기다린 뒤 하나의 응답 객체를 돌려준다.
# response = client.models.generate_content(
#     model=MODEL,
#     contents="RAG(검색 증강 생성)을 주니어 백엔드 개발자들에게 두 문장으로 설명해줘."
# )

# # print(response) #세부 내역도 나옴
# print(response.text) # 딱 답변만 출력됨
# print("======기본 호출======")

# print("======시스템 프롬프트 호출======")

# response = client.models.generate_content(
#     model=MODEL,
#     contents="출석 인정 기준이 궁금해",
#     # 응답 시 추가 설정
#     config=types.GenerateContentConfig(
#         # "시스템 프롬프트": 응답 시 value를 참고해서 대답할 수 있게 한다.
#         system_instruction=(
#             "너는 '원티드 AI 백엔드 개발자 과정 학습 도우미'야."
#             "정중한 존댓말을 써야하며, 답변은 3문장 이내로 간결히 해줘."
#         ),
#         # 출력의 무작위성(0과 가까울수록 일관적이며 높을수록 창의적이고 다양하다.)
#         temperature=0.2
#     )
# )

# print(response.text)

# print("======시스템 프롬프트 호출======")

print("======스트리밍 호출======")

stream = client.models.generate_content_stream(
    model=MODEL,
    contents="점점 등교길 언덕이 높아지는 것처럼 힘들어지는 이유에 대한 추론 3가지를 알려줘"
)

for chunk in stream:
    # end="", flush=True: 줄바꿈 없이 즉시 이어서 출력하는 print() 함수
    print(chunk.text or "", end="", flush=True)
print()

print("======스트리밍 호출======")