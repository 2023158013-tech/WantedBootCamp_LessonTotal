package com.jeongrim.practice.module03.array;

import java.util.Scanner;

public class ArrayPractice3 {
    public void practice3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("양의 정수: ");
        int num = sc.nextInt();
        int[] arr = new int [num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayPractice3 prac3 = new ArrayPractice3();
        prac3.practice3();
    }
}
