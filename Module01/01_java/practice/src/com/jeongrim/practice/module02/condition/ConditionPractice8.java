package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice8 {
    public void practice8() {

        //8.
        Scanner sc = new Scanner(System.in);

        System.out.println("피연산자1 입력: ");
        int num1 = sc.nextInt();
        System.out.println("피연산자2 입력: ");
        int num2 = sc.nextInt();
        System.out.println("연산자를 입력(+, -, *, /, %)");
        String oper = sc.next();
        int result = 0;

        if ((num1<0) || (num2<0)) {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
        }
        switch (oper){
            case "+":
                result = num1 +  num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
                break;
            default:
                System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
                break;

        }

        System.out.println(num1 + oper + num2 + "=" + result);
    }

    public static void main(String[] args) {
        ConditionPractice8 cal = new ConditionPractice8();
        cal.practice8();
    }
}
