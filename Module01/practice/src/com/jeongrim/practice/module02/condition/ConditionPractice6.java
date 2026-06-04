package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice6 {
    public void Practice6() {
        //6.
        Scanner sc = new Scanner(System.in);

        System.out.println("권한을 확인하고자 하는 회원 등급: ");
        String role = sc.nextLine();

        if (role.equals("관리자")){
            System.out.println("회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성");
        } else if (role.equals("회원")) {
            System.out.println("게시글 작성, 게시글 조회, 댓글 작성");
        } else if (role.equals("비회원")) {
            System.out.println("게시글 조회");
        } else {
            System.out.println("잘못 입력했습니다.");
        }
    }

    public static void main(String[] args) {
        ConditionPractice6 check = new ConditionPractice6();
        check.Practice6();
    }
}
