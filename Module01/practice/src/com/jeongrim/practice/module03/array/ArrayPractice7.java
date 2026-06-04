package com.jeongrim.practice.module03.array;

import java.util.Scanner;

public class ArrayPractice7 {
    public void practice7() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수: ");
        int arrLength = sc.nextInt();
        int[] arr = new int [arrLength];
        int arrNum = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("배열 " + i + "번째 인덱스에 넣을 값: ");
            arrNum = sc.nextInt();
            arr[i] = arrNum;
            sum += arr[i];
        }
        for (int j = 0; j < arr.length; j++) { //전체 배열 출력을 위의 for문에서 하면 배열 출력문이 반복됨.
            System.out.print(arr[j] + " ");
        }
        System.out.println("총 합: " + sum);

    }

    public static void main(String[] args) {
        ArrayPractice7 prac7 = new ArrayPractice7();
        prac7.practice7();
    }
}
