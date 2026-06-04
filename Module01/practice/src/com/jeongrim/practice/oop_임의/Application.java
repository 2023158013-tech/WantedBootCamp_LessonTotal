package com.jeongrim.practice.oop_임의;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    /*카메라 앱 실행 프로그램
    *1. 휴대폰을 킨다.
     2. 카메라 앱을 실행한다.
     3. 버튼을 눌러 촬영한다.
     4. 다른 버튼을 누르면 동영상으로 촬영한다. 동영상 촬영 시간이 10초씩 증가한다.
     5. 휴대폰을 끄면 동영상이 정지되고 휴대폰이 꺼진다.
    */

    SmartPhone phone = new SmartPhone();

    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("========== 카메라 실행 프로그램 ==========");
        System.out.println("1. 휴대폰 켜기 ");
        System.out.println("2. 카메라 실행");
        System.out.println("3. 사진 촬영");
        System.out.println("4. 동영상 촬영");
        System.out.println("5. 휴대폰 끄기");
        System.out.println("9. 프로그램 종료");
        System.out.print("메뉴를 선택해주세요: ");


        int no = sc.nextInt();

        switch (no) {
            case 1:
                phone.isOn();
                break;
            case 2:
                phone.cameraOn();
                break;
            case 3:
                phone.photo();
                break;
            case 4:
                phone.video();
                break;
            case 5:
                phone.isOff();
                break;
            case 9:
                System.out.println("프로그램을 종료합니다.");
                break;
            default:
                System.out.println("잘못된 번호를 입력했습니다.");
                break;
        }
        if (no == 9) break;
    }

    }
}
