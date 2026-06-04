package com.wanted.c_method;

public class Application01 {

    public static void main(String[] args) { //public: 접근 제어자, void(피하다라는 뜻): return(반환값) 없음, main: 메소드명
                                            //String[]: 반환 타입, static: 정적(사전에 다깔아두는 것)

        /*
        * 메소드가 없을 때 발생하는 경우
        *
        /* 10개의 수를 더하고 결과를 반환받고 싶다. */
        int num1 = 1;
        int num2 = 2;
        System.out.println("1번째 연산: " + num1 + num2);

        int num3 = 5;
        int num4 = 6;
        System.out.println("2번째 연산: " + num3 + num4);

        //이제 2개의 수를 더하고 싶을 때마다 위의 3줄의 코드가 무한히 반복될 것이다.

        //다음 구문은 다른 모듈에서 배울 것이다.
        //클래스명 변수명 = new 클래스명(); (공식)
        Application01 app = new Application01(); //Application에 대한 존재를 컴퓨터에 각인

        System.out.println("1번째 연산: " + app.sumTwoNumber(100, 200));//숫자만 쳐도 a, b 변수에 담김
        //출력 구문 없으면 300출력 안됨. 300이라는 반환값이 담겨있기 때문에 app.sumTwoNumber를 또 다른 변수에 담을 수 있음
    }

    //main 메소드 바깥 영역

    /*
    * 메소드
    * 메소드는 특정 작업을 수행하는 코드 블럭이다.
    * 코드의 재사용성과 가독성을 향상시키기 위해서 사용이 된다.
    * 메소드는 프로그램의 구조를 체계적으로 만들고, 유지보수를 용이하게 한다.
    *
    * 형식:
    * [접근제어자] [반환 타입] 메소드명([매개변수 타입 매개변수명]) {
    *    실행할 코드
    *    return 반환값; //반환값이 있다면
    * }
    *
    * 접근제어자: 외부에서 해당 메소드에 접근할 수 있는 범위를 지정한다.
    * -public(공공의): 모든 클래스에서 접근 가능
    * -private: 같은 클래스 내부에서만 접근 가능
    * -protected: 같은 패키지 || 자식 클래스에서 접근 가능
    * */

    //두 개의 숫자를 전달받아, 더하기 기능을 수행하는 메소드(메소드명은 기능을 알아보기 쉽게 작성)
    public int sumTwoNumber(int a, int b) {//값 받을 준비를 함(main에서 전달해줘야 함)
                           //int a = 100, int b = 200이 됨
        return a + b; //총 300이 됨
    }
}
