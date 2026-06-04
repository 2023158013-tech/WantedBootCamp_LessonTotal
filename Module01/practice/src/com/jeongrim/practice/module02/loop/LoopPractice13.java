package com.jeongrim.practice.module02.loop;

import java.util.Scanner;

public class LoopPractice13 {
    public void practice13() {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열: ");
        String word = sc.nextLine();
        System.out.println("찾고자 하는 문자: ");
        char find = sc.nextLine().charAt(0);
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)==find) {
                count++;
            }
        }System.out.println("포함된 갯수: " + count);
    }

    public static void main(String[] args) {
        LoopPractice13 prac13 = new LoopPractice13();
        prac13.practice13();
    }
}
