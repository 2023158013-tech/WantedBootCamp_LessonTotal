package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice2 {
    public void practice2() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("1 이상의 숫자를 입력하세요: ");
            num = sc.nextInt();
            if (num < 1) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        } while (num < 1);
            for (int i = 1; i <= num; i++){
                System.out.print(i + " ");
            }

    }

    public static void main(String[] args) {
        LoopPractice2 prac2 = new LoopPractice2();
        prac2.practice2();
    }
}
