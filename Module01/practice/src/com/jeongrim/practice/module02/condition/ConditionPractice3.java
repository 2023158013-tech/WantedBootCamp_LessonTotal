package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice3 {
    public void practice3() {
        //3.
        Scanner sc = new Scanner(System.in);
        System.out.println("국어 점수: ");
        int Kor = sc.nextInt();
        System.out.println("수학 점수: ");
        int Mat = sc.nextInt();
        System.out.println("영어 점수: ");
        int Eng = sc.nextInt();

        double sum = Kor + Mat + Eng;
        double Avg = sum/3;

        if(Kor>=40&&Mat>=40&&Eng>=40&&Avg>=60) {
            System.out.println("국어: " + Kor +"\n수학: "  + Mat + "\n영어: " + Eng + "\n합계: " + sum +"\n평균: " + Avg + "\n축하합니다, 합격입니다!");
        } else {
            System.out.println("불합격입니다.");
        }

    }

    public static void main(String[] args) {
        ConditionPractice3 pass = new ConditionPractice3();
        pass.practice3();
    }
}
