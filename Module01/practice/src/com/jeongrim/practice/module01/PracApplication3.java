package com.jeongrim.practice.module01;

import java.util.Scanner;

public class PracApplication3 {
    public static void main(String[] args) {
        //3. 본인 정보 출력
        String name;
        int age;
        String sex;
        double height;
        Scanner sc = new Scanner(System.in);

        System.out.println("이름: ");
        name = sc.nextLine();
        System.out.println("나이: ");
        age = sc.nextInt();
        System.out.println("성별: ");
        sex = sc.next();
        System.out.println("키: ");
        height = sc.nextDouble();

        System.out.println(age + "살" + sex + " " + name + "님 키가" + height + "cm 이시군요!");
    }
}
