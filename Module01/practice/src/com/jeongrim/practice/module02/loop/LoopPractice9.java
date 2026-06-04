package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice9 {
    public void practice9() {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자: ");
        int num = sc.nextInt();
        int result;
        int numP = 0;

        if (num < 2 || num > 9) {
            System.out.println("2~9 사이의 숫자만 입력해주세요.");
        } else {
            for (int i = num; i <= 9; i++) {
                System.out.println("===== " + i + "단 =====");

                for (int j = 1; j <= 9; j++) {
                    result = i * j;
                    System.out.println(i + " " + "*" + " " + j + " " + "=" + " " + result);

                }
            }
        }
    }

    public static void main(String[] args) {
        LoopPractice9 prac9 = new LoopPractice9();
        prac9.practice9();
    }
}
