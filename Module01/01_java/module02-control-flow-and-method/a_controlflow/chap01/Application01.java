package com.wanted.a_controlflow.chap01;

public class Application01 {

    /*main(): 프로그램의 시작을 아리는 시발점*/
    public static void main(String[] args) {

        /*if문
        * if문은 조건식의 결과에 따라 프로그램의 실행 흐름을 분기시키는 제어문이다.
        * 조건식이true일 경우 코드 블록이 수행되며, false일 경우 코드 블록을 무시한다.
        * 형식: if(조건식) {실행 코드} [else{대체 코드}](없어도 되고 있어도 된다는 표현)
        * 조건식은 boolean 타입으로 평가되며, 단일 조건 혹은 복합 조건(논리 연산자 사용 가능)을 포함할 수 있다.
        * */

        int score = 75;

        //만약 점수가 90이상이면 A등급이 출력
        //만약 점수가 90미만, 80이상이면 B등급 출력
        //만약 점수가 80미만, 70이상이면 C등급 출력
        //그보다 낮으면 D등급 출력

        if(score >= 90) {
            System.out.println("A등급입니다!!");
        } else if (score >= 80) {
            System.out.println("B등급입니다!!");
        } else if (score >=70) {
            System.out.println("C등급입니다!!");
        } else {
            System.out.println("재수강 확정");
        }

            System.out.println("프로그램 종료합니다!!");
    }
}
