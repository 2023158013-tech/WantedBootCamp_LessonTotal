package com.jeongrim.practice.module02.method;

import java.util.Scanner;

public class MethodPractice4 {
    public void practice4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민번호를 입력하세요(- 포함): ");
        String bornNum = sc.next();
        char sexNum = bornNum.charAt(8);
        if (sexNum == '2' || sexNum == '4') {
            System.out.println("여자");
        } else {
            System.out.println("남자");
        }

    }

    public static void main(String[] args) {
        MethodPractice4 prac4 = new MethodPractice4();
        prac4.practice4();
    }
}
