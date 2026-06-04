package com.jeongrim.practice.module03.array;

public class ArrayPractice2 {
    public void practice2() {
        int[] arr = new int [10];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");

            //또 다른 방법(i가 0, 1, 2...일 때 10, 9, 8...이 나오게 계산)
            //for (int i = 0; i < arr.length; i++) {
            //    arr[i] = 10 - i;}
        }
    }

    public static void main(String[] args) {
        ArrayPractice2 prac2 = new ArrayPractice2();
        prac2.practice2();
    }
}
