package com.wanted.b_variable.chap01;

import java.util.Scanner; //Scanner의 위치를 볼 수 있음
//외부 라이브러리-java.base-java-util
public class Application2 {

    public static void main(String[] args) {

        //Scanner 클래스는 사용자의 입력을 저장할 수 있다.
        Scanner sc = new Scanner(System.in); //jdk에 포함되어 있는 클래스(Scanner)(대문자로 시작)
                                            //in: input의 약자
                                            //sc가 scanner라는 자료형
        System.out.println("이름을 입력해주세요 : ");
        String name = sc.nextLine(); //공간이었던 sc가 값으로 취급됨.
                                     //nextLine: 입력된 한 줄을 의미
        System.out.println("입력한 Name 값 : " + name);

        //sc.
    }
}
