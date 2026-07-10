from fastapi import APIRouter
from app.schemas.chat_schema import ChatRequest, ChatResponse
# Controller에서 Service 의존성 주입 준비
from app.service.ai_service import AIService

# 객체 하나 생성
# @RequestMapping("/api/v1/chat")
# class ~~

# @GetMapping("/{id}") => 풀 url은 "/api/v1/chat/{id}"
router = APIRouter(
    prefix= "/api/v1/chat", # "이전의" 전치사 = @RequestMapping("/api/v1/chat") 역할
    tags=["Chat-API"] # 스웨거 태그
)

# 서비스 객체 생성
ai_service = AIService()

# /api/v1//chat POST 요청을 처리하는 함수
@router.post("", response_model=ChatResponse) # 공백 작성 => 풀 url: 위에서 설정한 "/api/v1/chat"이 됨
def chat(request: ChatRequest):
    return ai_service.chat(request.question) # 주의: return 값이 ChatResponse와 같아야 함.