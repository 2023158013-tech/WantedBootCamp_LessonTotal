# FastAPI에서 Req, Res를 명확하게 정의한다.
# Pydantic Schema를 활용해서 Spring에서의 DTO + Valid를 적용

from fastapi import FastAPI
# BaseModel은 DTO 역할을 하는 객체라고 생각하면 된다. (≒ DTO 객체)
from pydantic import BaseModel, Field

app = FastAPI()

# /chat 요청 시에 Request Body에 {"question": "질문"}이 담겨서 온다.
# {"question": "질문"}을 하나의 클래스 객체로 만들 것이다.
# Pydantic 객체로 만들 때 클래스 생성 시 BaseModel을 넣어준다.

# Pydantic은 타입 검증을 자동으로 수행하게 된다. (:str <- 같은 힌트를 바탕으로)
# 만약 Type Hint를 int로 두었는데 정수로 변환될 수 없는 값(ex. 안녕)이 넘어오면 자동으로 검증 오류를 발생시킨다.
# 추가적으로 Field를 활용하게 되면 더 구체적인 조건을 지정할 수 있다.
class ChatRequest(BaseModel):
    # <el 표기법>
    # ge: greater equals (크거나 같은(~이상)), le: less equals(작거나 같은(~이하))(대소비교 관련 약자)
    # gt: greater than(초과), lt: less than(미만)
    question: str = Field(min_length=1, max_length=10, description="사용자의 질문") # 변수(필드) 선언

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