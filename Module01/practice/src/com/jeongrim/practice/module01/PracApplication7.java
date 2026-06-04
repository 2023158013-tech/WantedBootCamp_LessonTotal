package com.jeongrim.practice.module01;

public class PracApplication7 {
    public static void main(String[] args) {
        int numOfApples = 92;
        int sizeOfBucket = 10;
        int numOfBucket = 0;

        if (numOfApples % sizeOfBucket >=1 && numOfApples % sizeOfBucket <=10) {
            numOfBucket = (numOfApples / sizeOfBucket) + 1;
        } else {
            numOfBucket = numOfApples / sizeOfBucket;
        }

        System.out.println("필요한 바구니의 수: " + numOfBucket);

    }
}
