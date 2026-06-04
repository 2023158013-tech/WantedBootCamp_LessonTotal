package com.jeongrim.practice.module01;

import java.util.Scanner;

public class PracApplication6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("국어 점수: ");
        int Kor = sc.nextInt();
        System.out.println("수학 점수: ");
        int Math = sc.nextInt();
        System.out.println("영어 점수: ");
        int Eng = sc.nextInt();

        double sum = Kor + Math + Eng;
        double avg = sum / 3;
        System.out.println("합계: " + sum);
        System.out.println("평균: " + avg);

        if ((Kor>=40&&Math>=40&&Eng>=40)&&avg>=60){
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
    }
}
