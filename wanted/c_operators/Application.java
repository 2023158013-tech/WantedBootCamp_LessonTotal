package com.wanted.c_operators;

public class Application {

    public static void main(String[] args) {

        //연산자 테스트 데이터
        int a = 10; //선언과 동시에 초기화
        int b =3;

        //+, -, x, %, /
        //산술 연산
        //문자열 연산은 문자열 합치기에 특히 유의해야 한다.
        System.out.println("덧셈: " + (a + b));
        System.out.println("나눗셈: "+ (a / b));
        System.out.println("나머지: " + (a % b));

        //비교 연산
        //두 값을 비교하여 참(true), 거짓(false)을 반환하는 연산자.
        //==, !=, <, >, <=, >=

        boolean isGreater = a > b;
        System.out.println("isGreater = " + isGreater);

        //논리 연산
        //하나 이상의 "조건을 결합"하여 최종적인 참 또는 거짓을 평가한다.
        //&&(논리 AND), ||(논리 OR), !(논리 NOT)
        //AND(둘 다 만족해야 참), OR(둘 중 하나만 만족해도 참)

        boolean isTrue = true;
        boolean isFalse = false;

        System.out.println("둘 다 참인가?:" + (isTrue && isFalse));
        System.out.println("둘 중 하나가 거짓인가?:" + (isTrue || isFalse));
        System.out.println("NOT은 너가 거짓이라는 걸 부정한다.:" + !isFalse);

        //증감 연산(반복문에 많이 사용)(위치 중요)(정수에 사용할 수 있음)
        //변수의 값을 1씩 증가시키거나 감소시키는 연산자
        //++(증가), --(감소)
        //
        int age = 20;
        System.out.println("age = " + (++age));
        System.out.println("age = " + (age--)); //후위는 이 코드 후에 증가/감소됨

        System.out.println("age = " + age);

        char a33 = 'a';
        int num = a33;
        System.out.println("num = " + num);; //문자는 정수임(97: 소문자 a, 대문자 a: 65)(아스키 코드)
    }
}
