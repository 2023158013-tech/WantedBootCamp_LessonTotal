package com.wanted.restapi.section03.valid;

/*comment
*  @ControllerAdvice
*  -해당 클래스 내부에 @ExceptionHandler를 모아두고 Service 로직에서 Exception이 발생하면 핸들링을 했었다.
*  -다만 아직도 View를 리턴해야 하는 책임이 존재한다.
*  */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    //MethodArgumentNotValidException
    //@Valid를 통과하지 못하면 발생하는 예외 클래스
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException exception) {
        String code = "";
        String description = "";
        String detail = "";

        //에러가 존재한다면 동작할 구문
        if(exception.getBindingResult().hasErrors()) {
            //예외 발생 message를 detail에 담기
            detail = exception.getBindingResult().getFieldError().getDefaultMessage();

            //예외 발생 코드 추출
            String resultCode = exception.getBindingResult().getFieldError().getCode();
            System.out.println("resultCode = " + resultCode);

            switch (resultCode) {
                case "NotNull" :
                    //우리 프로젝트 규칙상 Code로 변경
                    code = "ERROR_CODE_001";
                    //code에 대한 설명
                    description = "필수값 누락";
            }

        }

        ErrorResponse errorResponse = new ErrorResponse(code, description, detail);

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

}
