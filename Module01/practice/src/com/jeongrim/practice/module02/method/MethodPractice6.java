package com.jeongrim.practice.module02.method;

import java.util.Scanner;

public class MethodPractice6 {
    public void practice6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수1: ");
        int num1 = sc.nextInt();
        System.out.println("정수2: ");
        int num2 = sc.nextInt();
        System.out.println("정수3: ");
        int num3 = sc.nextInt();

        if (num1 == num2 &&
                num2 == num3 && num3 == num1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        MethodPractice6 prac6 = new MethodPractice6();
        prac6.practice6();
    }
}
