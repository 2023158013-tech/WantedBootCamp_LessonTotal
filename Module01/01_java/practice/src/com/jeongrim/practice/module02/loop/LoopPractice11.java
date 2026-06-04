package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice11 {
    public void practice11() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시작 숫자: ");
        int startNum = sc.nextInt();
        System.out.println("공차: ");
        int diff = sc.nextInt();

        int currentNum = startNum;

        for (int i = 1; i <= 10; i++){
            System.out.print(currentNum + " ");
            currentNum += diff;
        }
    }

    public static void main(String[] args) {
        LoopPractice11 prac11 = new LoopPractice11();
        prac11.practice11();
    }
}
