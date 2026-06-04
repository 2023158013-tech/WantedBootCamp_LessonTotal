package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice7 {
    public void practice7() {
        //7.
        Scanner sc = new Scanner(System.in);

        double height = 0.0;
        double weight = 0.0;

        System.out.println("키(m)를 입력해주세요: ");
        height = sc.nextDouble();
        System.out.println("몸무게(kg)를 입력해주세요: ");
        weight = sc.nextDouble();

        double bmi = weight/(height*height);
        System.out.println("BMI 지수: " + bmi);
        if (bmi <18.5) {
            System.out.println("저체중");
        } else if (bmi < 23) {
            System.out.println("정상 체중");
        } else if (bmi < 25) {
            System.out.println("과체중");
        } else if (bmi < 30) {
            System.out.println("비만");
        } else {
            System.out.println("고도 비만");
        }

    }

    public static void main(String[] args) {
        ConditionPractice7 BMI = new ConditionPractice7();
        BMI.practice7();
    }
}
