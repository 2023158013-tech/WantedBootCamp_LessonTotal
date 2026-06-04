package com.jeongrim.practice.module03.array;

public class ArrayPractice10 {
    public void practice10() {
        int[] arr = new int [10];

        for (int i = 0; i < arr.length; i++) {
            int random = (int) (Math.random() * (arr.length)) + 1;
            //난수 생성을 반복문에서 하지 않으면 한 번 발생된 난수가 배열에 똑같이 들어가짐.
            //1부터 10까지이므로 +1 해야함.
            arr[i] = random;
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        ArrayPractice10 prac10 = new ArrayPractice10();
        prac10.practice10();
    }
}
