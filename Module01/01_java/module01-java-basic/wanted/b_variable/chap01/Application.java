package com.wanted.b_variable.chap01;

public class Application {

    public static void main(String[] args) {
        /*
         *리터럴이란?
         * -리터러럴은 소스 코드에 직접 작성된 "값" 그 자체를 의미한다.
         * -리터럴은 변수에 저장되기 전 순수한 값을 의미한다.
         * */
        //숫자형(정수형)
        byte bNum = 10;
        short sNum = 10;
        //int -> 자료형
        //ex -> 변수
        //10 -> 리터럴
        int ex = 10;
        long l = 10;

        //추후에 알아보기
//        String str = "";
        //문자형
        char ch = '4';

        //논리형
        boolean bl = true;
        boolean bl2 = false;

        //실수형
        float fl = 3.14f;
        double dl = 3.45;

        //-------------------------------------------
        //변수의 선언과 초기화(값을 변수에 넣음)
        int number = 10;
        int number2 = 20;

        //변수의 선언(비어있는 공간 생성)
        int number3;

        //변수의 초기화(만들어진 공간에 값 넣기)
        number3 = 30;

        System.out.println(number); //number가 활성화되어 색이 다르게 나옴
        System.out.println("첫 번째 숫자는: " + number + "입니다.");

    }
}
