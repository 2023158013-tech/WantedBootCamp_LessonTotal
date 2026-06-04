package com.jeongrim.practice.module03.array;

import java.util.Scanner;

public class ArrayPractice6 {
    public void practice6() {
        String[] week = {"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};
        Scanner sc = new Scanner(System.in);
        System.out.println("0 ~ 6 사이 숫자 입력: ");
        int num = sc.nextInt();

        if (num < 0 || num > 6) {
            System.out.println("잘못 입력하셨습니다.");
        } else {
            System.out.println(week[num]);
        }
    }

    public static void main(String[] args) {
        ArrayPractice6 prac6 = new ArrayPractice6();
        prac6.practice6();
    }
}
