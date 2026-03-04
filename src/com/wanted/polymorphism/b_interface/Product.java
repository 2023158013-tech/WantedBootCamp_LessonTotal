package com.wanted.polymorphism.b_interface;

public class Product extends Product1 implements InterfaceProduct{
    @Override
    public void methodA() {
        System.out.println("methodA 호출됨..");
    }

    @Override
    void abstMethod() {

    }
}
