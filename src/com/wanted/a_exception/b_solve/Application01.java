package com.wanted.a_exception.b_solve;

public class Application01 {
    public static void main(String[] args) {
        /*comment
        *  예외 처리 진행
        *  1. try-catch-finally
        *  -try: 예외가 발생할 가능성이 있는 코드 블럭
        *  -catch: 특정 예외를 처리한느 코드 블럭
        *  -finally: 예외 발생 여부와 관계 없이 항상 실행되는 블럭
        *  2. throws를 이용한 예외 전파
        *  -
        * */

        System.out.println("프로그램 시작됨...");

        try {
            //예외 발생 가능성이 있는 코드
            int result = 10/0;
            System.out.println("result = " + result);
        } catch (ArithmeticException e) { //e는 자료형(매개변수)(catch가 ArithmeticException오류가 발생하는 구문을 e에 넣음)
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("예외 발생!!! 0으로는 나눌 수 없습니다!!");
        } finally {
            System.out.println("예외 발생 여부와 관계 없이 실행됨...");
        }

        System.out.println("===========================================");

        try {
            checkAge(-10);
        } catch (IllegalArgumentException e) {
            //실제 예외는 checkAge 메소드에서 발생하지만, 에외를 throws했기 때문에 호출하는 main쪽에서 처리해야 한다.
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("예외 발생!!! 나이는 음수일 수 없습니다!!");
        }

        System.out.println("프로그램 종료됨...");
    }

    /*예외 전파와 throw 키워드
    * -throws는 메소드 선언부에 작성한다.
    * -예외에 대한 처리를 호출자(caller)에게 위임하는(떠넘기는) 키워드이다.
    * -이를 통해서 해당 메소드는 예외 처리 코드로 복잡해지지 않고 자신의 핵심 로직(코드)에 집중할 수 있게 된다.
    * */
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            //잘못된 전달인자가 왔을 때 발생시키는 예외 클래스(IllegalArgumentException)
            throw new IllegalArgumentException("나이는 음수일 수 없습니다.");
        }
        System.out.println("전달 받은 " + age + "는 유효한 숫자입니다.");
    }
}
