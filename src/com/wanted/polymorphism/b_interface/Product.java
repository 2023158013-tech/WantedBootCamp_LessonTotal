package com.wanted.polymorphism.b_interface;

//extends는 클래스 상속을 위한 키워드
//interfaceproduct를 상속받기 위해서는 implements 키워드 사용(나는 상속 받을 것이다)
public class Product extends Product1 implements InterfaceProduct{
    @Override
    public void methodA() {
        System.out.println("methodA 호출됨..");
    }

    @Override
    void abstMethod() {

    }
}
