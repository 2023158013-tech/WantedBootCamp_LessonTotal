package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice5 {
    public void Practice5() {
        //5.
        String id = "jeongrim";
        int pw = 1234;
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디: ");
        String idInput = sc.nextLine();
        System.out.println("비밀번호: ");
        int pwInput = sc.nextInt();

        if((id.equals(idInput)) && (pw == pwInput)){
            System.out.println("로그인 성공");
        }  else if (id != idInput){
            System.out.println("아이디가 틀렸습니다.");
        } else if (pw != pwInput){
            System.out.println("비밀번호가 틀렸습니다.");
        }
    }

    public static void main(String[] args) {
        ConditionPractice5 login = new ConditionPractice5();
        login.Practice5();
    }
}
