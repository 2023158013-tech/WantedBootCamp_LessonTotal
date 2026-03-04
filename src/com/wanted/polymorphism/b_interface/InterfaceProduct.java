package com.wanted.polymorphism.b_interface;

public interface InterfaceProduct {
    /* comment
     *   인터페이스는 구현부가 있는 메소드를 작성할 수 없다.
     *   또한 생성자 역시 가질 수 없다.
     *  */

    // 인터페이스는 생성자를 못 쓴다.
//    public InterfaceProduct() {}
    //일반 메소드 작성하듯이 하면 안됨. 인터페이스는 특수한 목적을 가진 클래스임.(상속에 강제성을 부여함)

    // 인터페이스는 구현부가 있는 메소드를 못 쓴다.
//    public void test() {}

    void methodA(); //접근제한자도 빼버림(public), {} 중괄호(구현부) 있으면 에러

    static void staticMethod() { //new키워드를 사용하지 않고 필요없지만 구현부 사용가능. 근데 굳이 인터페이스에 static 안씀
        // static 메소드는 구현부 작성이 가능하다.
    }
}
