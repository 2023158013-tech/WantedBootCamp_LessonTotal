package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice2 {
    public void practice2() {
        //2.
        System.out.println("숫자를 한 개 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        double num2 = sc.nextDouble();
        if(num2<0){
            System.out.println("양수만 입력해주세요.");
        } else if(num2 % 2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }

    }
    public static void main(String[] args) {
        ConditionPractice2 odd = new ConditionPractice2();
        odd.practice2();
    }
}
