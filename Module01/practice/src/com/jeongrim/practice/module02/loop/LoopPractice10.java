package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice10 {
    public void practice10() {
        Scanner sc = new Scanner(System.in);
        int num;
        int result;

        do {
            System.out.println("숫자: ");
            num = sc.nextInt();
            if(num < 2 || num >9) {
                System.out.println("2~9 사이의 숫자만 입력해주세요.");
            }
        } while (num < 2 || num > 9);

        for (int i = num; i <= 9; i++) {
            System.out.println("===== " + i + "단 =====");

            for (int j = 1; j <= 9; j++) {
                result = i * j;
                System.out.println(i + " " + "*" + " " + j + " " + "=" + " " + result);

            }
        }
    }

    public static void main(String[] args) {
        LoopPractice10 prac10 = new LoopPractice10();
        prac10.practice10();
    }
}
