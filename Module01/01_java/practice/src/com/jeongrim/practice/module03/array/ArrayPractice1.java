package com.jeongrim.practice.module03.array;

public class ArrayPractice1 {
    public void practice1() {
        int[] arr = new int [10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayPractice1 prac1 = new ArrayPractice1();
        prac1.practice1();
    }
}
