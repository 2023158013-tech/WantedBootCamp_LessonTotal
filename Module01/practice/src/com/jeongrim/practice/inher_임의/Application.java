package com.jeongrim.practice.inher_임의;

public class Application {
    public static void main(String[] args) {
        Beverage bevCof = new Coffee();
        Beverage bevT = new Tea();

        bevCof.Order();
        ((Coffee)bevCof).Order(3);
        bevT.Order();
    }
}
