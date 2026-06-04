package com.jeongrim.practice.module01;

import java.util.Scanner;

public class PracApplication5_2 {
    public static void main(String[] args) {
        int age;
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 입력: ");
        age = sc.nextInt();

        if (age>19){
            System.out.println("성인");
        } else if (age <= 13) {
            System.out.println("어린이");
        }else {
            System.out.println("청소년");
        }
    }
}
