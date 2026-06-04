package com.wanted.a_generic.a_basic;

import java.lang.reflect.GenericSignatureFormatError;

public class Application {
    public static void main(String[] args) {
        /*comment
        *  Generic이란?
        *  제네릭은 데이터의 타입을 일반화한다는 의미이다.
        *  클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 지정하는 바업을 의미한다.(컴파일: 타이핑 칠 때)(런타임: 코드 실행 시)
        *  (컴파일 시점에 오류가 나는 것이 런타임 시점에 오류나는 것보다 나음.)
        *  컴파일 시점에 미리 타입에 대한 검사를 진행하여, 클래스나 메소드 내부에서 사용되는 객체의 타입 안정성을 높일 수 있다.*/

        GenericTest gt = new GenericTest();
        gt.setValue(1);
        System.out.println("gt = " + gt);
        gt.setValue("문자열");
        System.out.println("gt = " + gt);
        System.out.println("=====================================");

        /*comment
        *  <> 다이아몬드 연산자 내부의 자료형은 기본자료형이 들어갈 수 없다.
        *  그러면 도대체 int, char, boolean 이런 값을 저장하고 싶다면 어떻게 해야 하나?
        *  -Wrapper 클래스가 등장하게 된다.(스택에 들어가는 기본자료형을 힙 메모리에 올리고 싶을 때)
        *  int -> Integer
        *  String -> String
        *  byte -> Byte
        *  short -> Short
        *  boolean -> Boolean
        *  char -> Character*/
        GenericTest<Integer> gt1 = new GenericTest<Integer>();
//        gt1.setValue("문자열");
        gt1.setValue(1);
        System.out.println("gt1 = " + gt1);

        GenericTest<String> gt2 = new GenericTest<String>();
        gt2.setValue("문자열");
        System.out.println("gt2 = " + gt2);

    }
}
