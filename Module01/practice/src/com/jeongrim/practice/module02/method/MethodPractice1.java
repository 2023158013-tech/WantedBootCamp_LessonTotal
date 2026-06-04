package com.jeongrim.practice.module02.method;

import java.util.Scanner;

public class MethodPractice1 {
    public void practice1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("성별을 입력하세요(남/여): ");
        char sex = sc.next().charAt(0);
        String sexString = "";
        if (sex == '남') {
            sexString = "남자";
        } else if (sex == '여') {
            sexString = "여자";
        }
        System.out.println("키를 입력하세요(cm): ");
        double height = sc.nextDouble();

        System.out.println("키 " + height + "인 " +
                age + "살 " + sexString + " " + name + "님 반갑습니다. ^^");

    }

    public static void main(String[] args) {
        MethodPractice1 prac1 = new MethodPractice1();
        prac1.practice1();
    }
}
