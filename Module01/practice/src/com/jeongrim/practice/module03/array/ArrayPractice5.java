package com.jeongrim.practice.module03.array;

import java.util.Scanner;

public class ArrayPractice5 {
    public void practice5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열: ");
        String word = sc.nextLine();
        System.out.println("문자: ");
        String find = sc.next();
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == find.charAt(0)) { //find는 한 글자라서 charAt()에 i를 없는 값들과 비교하게 됨.
                count++;

            }

        }System.out.println(find + " " + "갯수: " + count);
    }

    public static void main(String[] args) {
        ArrayPractice5 prac5 = new ArrayPractice5();
        prac5.practice5();
    }
}
