package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice1 {
    public void practice1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 이상의 숫자를 입력하세요: ");
        int num = sc.nextInt();

         if (num >= 1) {
            for (int i = 1; i <= num; i++) {
                System.out.print(i + " ");
            }
        } else if (num < 1) {
             System.out.println("잘못 입력하셨습니다.");
         }
    }

    public static void main(String[] args) {
        LoopPractice1 prac1 = new LoopPractice1();
        prac1.practice1();
    }
}
