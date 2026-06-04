package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice3 {
    public void practice3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 이상의 숫자를 입력하세요: ");
        int num = sc.nextInt();
        if (num < 1) {
            System.out.println("잘못 입력하셨습니다.");
        } else {
            for (int i = num; i >= 1; i--) {
                System.out.print(i + " ");
            }
        }

    }

    public static void main(String[] args) {
        LoopPractice3 prac3 = new LoopPractice3();
        prac3.practice3();
    }
}
