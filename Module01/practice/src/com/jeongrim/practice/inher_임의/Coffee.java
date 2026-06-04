package com.jeongrim.practice.inher_임의;

public class Coffee extends Beverage{
    @Override
    public void Order() {
        System.out.println("원두 향이 나는 커피를 주문합니다.");
    }

    public void Order(int shot) {
        System.out.println("샷을 " + shot + "개 추가합니다.");
    }
}
