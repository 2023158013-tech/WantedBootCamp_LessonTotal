from pydantic import BaseModel, Field

# 해당 파일은 Chat 관련 Req, Res 객체를 작성하는 곳.

class ChatRequest(BaseModel):
    question: str = Field(min_length=1, max_length=10, description="사용자의 질문") # 변수(필드) 선언

# 응답 객체 생성
class ChatResponse(BaseModel):
    question: str # 사용자 질문
    answer: str # 답변
    model: str # 사용한 모델 종류
    used_token: int # 토큰 사용량