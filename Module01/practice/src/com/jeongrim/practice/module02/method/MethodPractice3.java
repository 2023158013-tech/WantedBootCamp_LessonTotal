package com.jeongrim.practice.module02.method;

import java.util.Scanner;

public class MethodPractice3 {
    public void practice3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름: ");
        String name = sc.nextLine();
        System.out.println("학년(숫자만): ");
        int grade = sc.nextInt();
        System.out.println("반(숫자만): ");
        int clas = sc.nextInt();
        System.out.println("번호(숫자만): ");
        int number = sc.nextInt();
        System.out.println("성별(M/F): ");
        String sex = sc.next();
        if (sex.equals("M") || sex.equals("m")) {
            sex = "남학생";
        } else {
            sex = "여학생";
        }
        System.out.println("성적(소수점 아래 둘째 자리까지): ");
        double score = sc.nextDouble();
        System.out.println(grade + "학년" + " " + clas +"반" + " " +
                number + "번" + " " + name + " " + sex +"의 성적은 " + score + "이다.");
    }

    public static void main(String[] args) {
        MethodPractice3 prac3 = new MethodPractice3();
        prac3.practice3();
    }
}
