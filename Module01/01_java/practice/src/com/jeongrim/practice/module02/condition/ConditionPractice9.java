package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice9 {
    public void practice9() {
        //9.
        Scanner sc = new Scanner(System.in);
        System.out.println("중간 고사 점수: ");
        int med = sc.nextInt();
        System.out.println("기말 고사 점수: ");
        int fin = sc.nextInt();
        System.out.println("과제 점수: ");
        int hw = sc.nextInt();
        System.out.println("출석 횟수: ");
        int att = sc.nextInt();

        double score = (med*0.2)+(fin*0.3)+(hw*0.3)+(att*0.2*5);

        System.out.println("=======결과========" +
                "\n중간 고사 점수(20): " + (med*0.2)+
                "\n기말 고사 점수(30): " + (fin*0.3) +
                "\n과제 점수(30): " + (hw*0.3) +
                "\n출석 점수(20): " + (att*0.2*5) +
                "\n총점: " + score);

        if ((med>100) || (fin>100) || (hw>100) || (att>20)) {
            System.out.println("잘못입력하셨습니다.");
        } else if (score >= 70 && att >= 14) {
            System.out.println("Pass");
        }
        if (att<14) {
            System.out.println("Fail[출석 횟수 부족] (" + att + "/20)");
        }
        if (score < 70){
            System.out.println("Fail[점수 미달] (총점 " + score + ")");
        }

    }

    public static void main(String[] args) {
        ConditionPractice9 finalScore = new ConditionPractice9();
        finalScore.practice9();
    }
}
