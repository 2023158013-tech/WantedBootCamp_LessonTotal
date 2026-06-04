package com.wanted.a_exception.c_userexception.exception;

/*comment
*  예외 처리 클래스 만드는 방법
*  extends Exception*/
public class NegativeException extends Exception{

    public NegativeException(String msg) {
        super(msg); //부모(Exception->Throwable)의 생성자에게 메시지 전달
    }

}
