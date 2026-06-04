package com.jeongrim.practice.module02.loop;

public class LoopPractice14 {
    public void practice14() {
        int donate = 70;
        int donateCount = 0;
        int finalDonate = 10000;
        int currentDonate = 0;

        System.out.println("--------------------------");
        for (int i = 1;; i++) {
            currentDonate += donate;
            donateCount++;
            System.out.println(i + "회 모금액: " + currentDonate+"원");
            if (currentDonate >= finalDonate) {
                System.out.println("총 모금횟수: " + donateCount);
                break;
            }
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {
        LoopPractice14 prac14 = new LoopPractice14();
        prac14.practice14();
    }
}


