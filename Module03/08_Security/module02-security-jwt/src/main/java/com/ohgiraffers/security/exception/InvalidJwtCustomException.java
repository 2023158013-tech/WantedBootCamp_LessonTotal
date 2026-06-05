package com.ohgiraffers.security.exception;
//유효하지 않을 때
public class InvalidJwtCustomException extends RuntimeException {
    public InvalidJwtCustomException(String message) {
        super(message);
    }

    public InvalidJwtCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
