package com.jeongrim.practice.module02.method;

import java.util.Scanner;

public class MethodPractice7 {
    public void practice7() {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수: ");
        int num = sc.nextInt();

        if (num >= 90) {
            System.out.println("축하합니다.");
        } else {
            System.out.println("분발하세요.");
        }

    }

    public static void main(String[] args) {
        MethodPractice7 prac7 = new MethodPractice7();
        prac7.practice7();
    }
}
