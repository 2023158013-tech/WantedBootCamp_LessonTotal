package com.wanted.a_controlflow.chap02;

public class Application {

    public static void main(String[] args) {

        /*switch문
        * switch문은 변수나 식의 값에 따라 실행 경로를 선택하는 제어문이다.
        * 형식: switch (식) {case 값: 실행 코드; break; default: 기본코드;}
        * 식 - 정수, 문자열 등 비교가 가능한 타입이 들어갈 수 있다.
        * case - 특정 값과 비교하여 해당 값이 일치할 때 실행할 코드를 정의
        * break - 분기를 종료한다. switch 블록을 빠져나가게 된다.
        * 다중 if-else를 대체하며, 값 기반의 분기에 적합하다.
        * */

        int month = 1;

        switch(month) {
            case 1:
                System.out.println("1월입니다~");
                break;
            case 2:
                System.out.println("2월입니다~");
                break;
            case 3:
                System.out.println("3월입니다~");
                break;
            default:
                System.out.println("그 외의 월입니다~~~");
        }

    }
}
