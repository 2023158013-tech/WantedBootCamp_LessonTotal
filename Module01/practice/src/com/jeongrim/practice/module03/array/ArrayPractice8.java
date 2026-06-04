package com.jeongrim.practice.module03.array;

import java.util.Scanner;

public class ArrayPractice8 {
    public void practice8() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while (true) {
            System.out.println("정수: ");
            num = sc.nextInt();
            if (num % 2 == 0 || num < 3) {
                System.out.println("다시 입력하세요.");
            } else break;
        }
        int[] arr = new int[num];
        int lengHalf = arr.length/2;
        for (int i = 0; i <= lengHalf; i++) {
                arr[i] = i + 1;
            }
        for (int j = lengHalf + 1; j < num; j++) { //배열의 반 다음부터 채우기
            arr[j] = num - j; //ex. num = 5면 배열 길이가 5, 배열의 반은 2, 반+1은 3
                              //즉, 3번째 인덱스부터 5-3 -> 5-4 ...를 진행
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        ArrayPractice8 prac8 = new ArrayPractice8();
        prac8.practice8();
    }
}
