package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice5 {
    public void practice5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 하나 입력하세요: ");
        int num = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum += i;
            System.out.print(i + " " + "+" + " ");

        } System.out.print("=" + " " + sum);
    }

    public static void main(String[] args) {
        LoopPractice5 prac5 = new LoopPractice5();
        prac5.practice5();
    }
}
