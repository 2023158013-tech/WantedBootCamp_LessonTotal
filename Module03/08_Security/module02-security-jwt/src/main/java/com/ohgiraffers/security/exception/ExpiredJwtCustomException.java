package com.ohgiraffers.security.exception;
//토큰 만료됐을 때
import io.jsonwebtoken.JwtException;

public class ExpiredJwtCustomException extends JwtException {

    public ExpiredJwtCustomException(String message) {
        super(message);
    }
}
