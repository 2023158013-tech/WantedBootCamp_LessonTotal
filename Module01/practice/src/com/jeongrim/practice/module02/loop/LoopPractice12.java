package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice12 {
    public void practice12() {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;
        String op;
        int result = 0;

        do {
            System.out.println("연산자(+, -, *, /, %): ");
            op = sc.next();
            if (op.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.println("정수1: ");
            num1 = sc.nextInt();
            System.out.println("정수2: ");
            num2 = sc.nextInt();

            switch (op) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                default:
                    System.out.println("없는 연산자입니다. 다시 입력해주세요.");
                    continue;
            }
            System.out.println(num1 + " " + op + " " + num2 + " " + "=" + " " + result);

        } while (!op.equals("exit"));
    }
    public static void main(String[] args) {
        LoopPractice12 prac12 = new LoopPractice12();
        prac12.practice12();
    }
}
