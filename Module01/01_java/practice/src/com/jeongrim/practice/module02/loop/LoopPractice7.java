package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice7 {
    public void practice7() {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;

        do {
            System.out.println("첫 번째 숫자: ");
            num1 = sc.nextInt();
            System.out.println("두 번째 숫자: ");
            num2 = sc.nextInt();

            if (num1 < 1 || num2 < 1) {
                System.out.println("1 이상의 숫자를 입력해주세요.");
            }
            if (num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
        } while (num1 < 1 || num2 < 1);
        for (int i = num1; i <= num2; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        LoopPractice7 prac7 = new LoopPractice7();
        prac7.practice7();
    }
}
