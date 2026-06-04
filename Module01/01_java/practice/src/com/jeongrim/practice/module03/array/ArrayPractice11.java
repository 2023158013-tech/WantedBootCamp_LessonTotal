package com.jeongrim.practice.module03.array;

import java.util.Scanner;

public class ArrayPractice11 {
    public void practice11() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민등록번호(-포함): ");
        String bornNum = sc.next();
        char copy[] = new char[bornNum.length()];

        for (int i = 0; i < bornNum.length(); i++) {
            copy[i] = bornNum.charAt(i);
        }
        for (int i = 8; i < copy.length; i++) { //인덱스는 0부터 시작이므로 7번째부터 *로 변경
            copy[i] = '*';
        }
        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i]);
        }

    }

    public static void main(String[] args) {
        ArrayPractice11 prac11 = new ArrayPractice11();
        prac11.practice11();
    }
}
