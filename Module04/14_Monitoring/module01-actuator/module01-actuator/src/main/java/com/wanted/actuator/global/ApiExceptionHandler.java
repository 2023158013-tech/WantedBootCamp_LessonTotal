package com.wanted.actuator.global;

import com.wanted.actuator.global.log.RequestLoggingFilter;
import com.wanted.actuator.metric.ShopMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    //롬복 미설치로 로그 직접 설정
    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    //예외 핸들링 시 Custom Metric 심을 준비
    private final ShopMetrics shopMetrics;

    public ApiExceptionHandler(ShopMetrics shopMetrics) {
        this.shopMetrics = shopMetrics;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgumentException(IllegalArgumentException exception) {
        shopMetrics.recordApiError("bad_request");

        //Error Log 심기
        //api_error는 모든 에러, bad_request는 특정
        log.warn(
                "event=api_error reason=bad_request exceptionType={} message=\"{}\"",
                exception.getClass().getSimpleName(),
                exception.getMessage()
        );

        return Map.of("message", exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        shopMetrics.recordApiError("validation");
        String message = exception.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .orElse("요청 값이 올바르지 않습니다.");

        //어떤 필드가 유효성 검사에 실패했는지도 로그에 찍히도록 함
        String field = exception.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(error -> error.getField())
                .orElse("unknown");
        log.warn(
                "event=api_error reason=validation field={} exceptionType={} message=\"{}\"",
                field,
                exception.getClass().getSimpleName(),
                message
        );

        return Map.of("message", message);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleException(Exception exception) {
        // 처리되지 않은 서버 오류도 제한된 reason 태그로만 기록한다.
        // exception.message나 요청별 ID를 태그로 넣지 않는다.
        shopMetrics.recordApiError("server_error");

        //해당 ExceptionHandler는 우리가 예측하지 못하는 예외가 발생했을 때 동작하는 핸들러이다.
        //이럴 때는 log level을 warn이 아닌 error로 설정하여 반드시 확인해야 하는 Log로 분류한다.
        log.error(
                "event=api_error reason=server_error exceptionType={} message=\"{}\"",
                exception.getClass().getSimpleName(),
                exception.getMessage(),
                exception
        );
        return Map.of("message", "서버 오류가 발생했습니다.");


    }
}
