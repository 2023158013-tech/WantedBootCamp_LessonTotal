from app.schemas.chat_schema import ChatRequest, ChatResponse

# 응답 타입을 ChatResponse로 맞춰줘야 chat_router에서 정상 동작함

class AIService:
    def chat(self, question:str) -> ChatResponse:
        # 클래스 내부의 Helper 함수 호출
        # self는 AIService 객체를 의미한다. == Java의 this
        answer = self.create_answer(question)
        
        return ChatResponse(
            question=question,
            answer=answer,
            model="gemini-flash",
            used_token=10000
        )
        
    def create_answer(self, question:str) -> str:
        return f"{question}에 대한 AI 답변 생성 호출"