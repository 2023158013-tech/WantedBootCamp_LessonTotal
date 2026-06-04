package com.jeongrim.practice.module02.method;

import java.util.Scanner;

public class MethodPractice5 {
    public void practice5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수1: ");
        int num1 = sc.nextInt();
        System.out.println("정수2: ");
        int num2 = sc.nextInt();
        System.out.println("비교값: ");
        int compareNum = sc.nextInt();

        if (compareNum <= num1 || compareNum > num2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        MethodPractice5 prac5 = new MethodPractice5();
        prac5.practice5();
    }
}
