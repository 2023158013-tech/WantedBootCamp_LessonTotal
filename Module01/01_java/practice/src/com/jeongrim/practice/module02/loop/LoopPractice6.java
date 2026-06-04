package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice6 {
    public void practice6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자: ");
        int num1 = sc.nextInt();
        System.out.println("두 번째 숫자: ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num1 < 1 || num2 < 1) {
            System.out.println("1 이상의 숫자만을 입력해주세요.");
        } else {
            for (int i = num1; i <= num2; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        LoopPractice6 prac6 = new LoopPractice6();
        prac6.practice6();
    }
}
