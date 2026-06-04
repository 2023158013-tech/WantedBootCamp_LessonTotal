package com.jeongrim.practice.module02.method;

import java.util.Scanner;

public class MethodPractice2 {
    public void practiec2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요: ");
        String word = sc.nextLine();

        for (int i = 0; i < 3; i++) {
            char ch = word.charAt(i);

            System.out.println((i+1) + "번째 문자: " + ch);
        }
    }

    public static void main(String[] args) {
        MethodPractice2 prac2 = new MethodPractice2();
        prac2.practiec2();
    }
}
