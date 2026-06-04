package com.jeongrim.practice.module01;

public class PracApplication5 {
    public static void main(String[] args) {
        //5. 점수들의 총점 및 평균 출력
        double Kor = 80.5;
        double Math = 50.6;
        double Eng = 70.8;

        int sum =(int) (Kor + Math + Eng);
        int avg = sum/3;

        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);

    }
}
