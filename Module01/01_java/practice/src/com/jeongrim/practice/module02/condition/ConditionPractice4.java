package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice4 {
    public void practice4() {
        //4.
        Scanner sc = new Scanner(System.in);
        System.out.println("1~12 사이의 정수 입력: ");
        int month = sc.nextInt();
        String season = " ";

        switch(month) {
            case 1, 2, 12:
                System.out.println(month + "월은 겨울입니다.");
                break;

            case 3, 5:
                System.out.println(month + "월은 봄입니다.");
                break;

            case 6, 8:
                System.out.println(month + "월은 여름입니다.");
                break;

            case 9, 11:
                System.out.println(month + "월은 가을입니다.");
                break;

            default:
                System.out.println(month + "월은 잘못 입력된 달입니다.");
                break;

        }

    }

    public static void main(String[] args) {
        ConditionPractice4 season = new ConditionPractice4();
        season.practice4();
    }
}
