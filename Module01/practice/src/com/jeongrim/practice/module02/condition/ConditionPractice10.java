package com.jeongrim.practice.module02.condition;

import java.util.Scanner;

public class ConditionPractice10 {
    public void menuView() {
        //10.
        System.out.println("실행할 기능을 선택하세요." +
                "\n1. 메뉴 출력" + "\n2. 짝수/홀수" + "\n3. 합격/불합격" +
                "\n4. 계절" + "\n5. 로그인" + "\n6. 권한 확인" +
                "\n7. BMI" + "\n8. 계산기" + "\n9. 점수 결과 출력");
        System.out.println("선택: ");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();

        if (select == 1) {
            ConditionPractice1 menu = new ConditionPractice1();
            menu.practice1();
        } else if (select == 2) {
            ConditionPractice2 odd = new ConditionPractice2();
            odd.practice2();
        } else if (select == 3) {
            ConditionPractice3 Pass = new ConditionPractice3();
            Pass.practice3();
        } else if (select == 4) {
            ConditionPractice4 season = new ConditionPractice4();
            season.practice4();
        } else if (select == 5) {
            ConditionPractice5 login = new ConditionPractice5();
            login.Practice5();
        } else if (select == 6) {
            ConditionPractice6 check = new ConditionPractice6();
            check.Practice6();
        } else if (select == 7) {
            ConditionPractice7 BMI = new ConditionPractice7();
            BMI.practice7();
        } else if (select == 8) {
            ConditionPractice8 cal = new ConditionPractice8();
            cal.practice8();
        } else if (select == 9) {
            ConditionPractice9 scoreResult = new ConditionPractice9();
            scoreResult.practice9();
        }

    }

    public static void main(String[] args) {
        ConditionPractice10 program = new ConditionPractice10();
        program.menuView();
    }
}
