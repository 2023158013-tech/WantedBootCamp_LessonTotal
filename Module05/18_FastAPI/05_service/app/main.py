from fastapi import FastAPI
from app.api.chat_router import router as chat_router 
# as: 별칭을 정한다. router 변수가 겹치기 때문에 각각의 파일에서 사용하는 router에 대한 변수명을 바꿔준다.
# as 설정이 없다면 rag_router 임포트 시 변수명이 겹침 -> 하나가 덮어써짐
# from app.api.rag_router import router as rag_router

# Swagger 설정을 할 수 있다.
app = FastAPI( # 스웨거 커스터마이징
    title="FastAPI Router Server",
    description="Spring Backend와 소통하는 AI Server",
    version="1.0.0"
)

# health check 관련 api 작성: 서버가 살아있는지 확인하는 목적
@app.get("/")
def health_check():
    return {"status": "ok", "code": 200, "message": "Very Good!"}

# fastapi 객체에 라우터 등록
app.include_router(chat_router)