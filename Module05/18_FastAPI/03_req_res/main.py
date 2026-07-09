# FastAPI에서 Req, Res를 명확하게 정의한다.
# Pydantic Schema를 활용해서 Spring에서의 DTO + Valid를 적용

from fastapi import FastAPI
# BaseModel은 DTO 역할을 하는 객체라고 생각하면 된다. (≒ DTO 객체)
from pydantic import BaseModel, Field

app = FastAPI()

# /chat 요청 시에 Request Body에 {"question": "질문"}이 담겨서 온다.
# {"question": "질문"}을 하나의 클래스 객체로 만들 것이다.
# Pydantic 객체로 만들 때 클래스 생성 시 BaseModel을 넣어준다.
class ChatRequest(BaseModel):
    question: str # 변수(필드) 선언

# 응답 객체 생성
class ChatResponse(BaseModel):
    question: str # 사용자 질문
    answer: str # 답변
    model: str # 사용한 모델 종류
    used_token: int # 토큰 사용량
    
# 응답 시 활용할 클래스는 endPoint 두번째 인자에 작성한다.
@app.post("/chat", response_model=ChatResponse)
def chatbot(request: ChatRequest):

    return ChatResponse(
        question=request.question,
        answer=f"{request.question}에 대한 답변",
        model="gemini-flash",
        used_token=100000
    )