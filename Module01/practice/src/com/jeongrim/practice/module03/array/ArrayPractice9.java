package com.jeongrim.practice.module03.array;

import java.util.Scanner;

public class ArrayPractice9 {
    public void practice9() {
        String[] menu = {"양념", "후라이드", "고추마요", "반반"};
        Scanner sc = new Scanner(System.in);
        System.out.println("치킨 이름을 입력하세요: ");
        String order = sc.nextLine();

        int i;
        for (i = 0; i < menu.length; i++) {
            if (order.equals(menu[i])) {
                System.out.println(menu[i] + " 치킨 배달 가능");
                break;
            }
        }
        if (i == menu.length){ //i가 배열의 길이와 같다는 것 = 배열의 끝까지 break를 만나지 않은 것
                               //즉, order와 menu가 일치하지 않음
            System.out.println(order + " 치킨은 없는 메뉴입니다.");
        }
    }

    public static void main(String[] args) {
        ArrayPractice9 prac9 = new ArrayPractice9();
        prac9.practice9();
    }
}
