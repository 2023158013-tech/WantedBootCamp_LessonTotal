package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice1 {
    public void practice1() {
        //1.
        System.out.println("1. 수정, 2. 조회, 3. 삭제, 4. 종료: ");
        System.out.println("메뉴 번호를 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num==1){
            System.out.println("수정 메뉴입니다.");
        } else if(num==2){
            System.out.println("조회 메뉴입니다.");
        } else if(num==3){
            System.out.println("삭제 메뉴입니다.");
        } else {
            System.out.println("종료 메뉴입니다.");
        }

    }
    public static void main(String[] args) {
        ConditionPractice1 menu = new ConditionPractice1();
        menu.practice1();
    }
}
