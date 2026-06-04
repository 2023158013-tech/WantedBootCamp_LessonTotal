package com.wanted.polymorphism.a_polymorphism;

public class Koala extends Animal{

    //extends 확장하고 alt+insert -> 메소드 재정의 -> shift+아래 방향키
    @Override
    public void eat() {
        System.out.println("코알라가 유칼립투스 잎을 먹습니다.");
    }

    @Override
    public void run() {
        System.out.println("코알라가 다른 나무로 폴~짝 뛰어갑니다");
    }

    @Override
    public void bark() {
        System.out.println("코알코알");
    }

    //자식인 코알라만의 기능
    public void sleep() {
        System.out.println("코알라는 하루에 20시간을 숙면합니다..zzz");
    }
}
