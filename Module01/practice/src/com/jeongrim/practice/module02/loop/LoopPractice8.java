package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice8 {
    public void practice8() {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자: ");
        int num = sc.nextInt();
        int result = 0;

        System.out.println("===== " + num + "단 =====");
        for (int i = 1; i <= 9; i++) {
            result = num * i;
            System.out.println(num + " " + "*" + " " + i + " " + "=" + " " + result);
        }

    }

    public static void main(String[] args) {
        LoopPractice8 prac8 = new LoopPractice8();
        prac8.practice8();
    }
}
