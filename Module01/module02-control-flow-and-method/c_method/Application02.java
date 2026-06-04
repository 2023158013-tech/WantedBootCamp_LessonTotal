package com.wanted.c_method;

public class Application02 {
    public static void main(String[] args) {
        /*
        * 메소드란?
        * 메소드는 어떤 특정 작업을 수행하기 위한 명령문의 집합이다.
        * */

        //1. 메인 메소드가 가장 먼저 동작함
        System.out.println("main() 시작됨...");

        //2. 메인 메소드 밖에 methodA를 추가해보자.

        //5. 작성한 methodA를 호출하는 구문
        //comment. 클래스명 변수명 = new 클래스명();
        //-> 무대에 올라가는 구문
        Application02 app2 = new Application02(); //이 구문 쓰면 메소드 호출 가능(정확한 클래스 작성해야 함)
        app2.methodA(); //메소드 호출 구문

        //6. main 메소드 최하단부 종료 코드
        System.out.println("프로그램 종료됨...");

        //7. methodA 흐름 확인 후 methodB() 추가


    }

    //3. 메인 메소드에서 호출이 되는지를 확인
    public void methodA() { //2. public: 접근제어자, void(return없음): 반환타입(자료형)

        //4. 호출 확인을 위한 출력 구문
        System.out.println("methodA() 호출됨...");

        //12. methodB() 호출 구문 작성
        methodB(); //11.

        //13. methodA() 종료되는 시점 확인을 위한 출력문 작성
        System.out.println("methodA() 종료됨...");

    }

    //8. 호출 확인을 위한 methodB 작성
    public void methodB() { //7.

        //9. methodA와 같은 방식으로 호출 확인을 위한 출력 구문
        System.out.println("methodB() 호출됨");

        //10. 작성만 해두고 App을 동작시켜본다.
        //실행을 하면 methodB의 출력 구문은 동작하지 않는다.
        //왜냐? 부르지 않았기 때문에.

        //11. methodA() 내부에서 methodB()를 호출해보자.
    }
}

/* 스택 그림(선입후출(LIFO): 가장 먼저들어온 게 제일 늦게 나감)(=위만 뚫린 바구니)(양 옆이 뚫린 구조도 있음: 선입선출(FIFO)(큐, ex. 대기열))
* methodB
* methodA
* main(제일 먼저 쌓임)
* */