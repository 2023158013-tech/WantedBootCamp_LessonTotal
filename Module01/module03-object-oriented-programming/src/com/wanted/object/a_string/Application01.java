package com.wanted.object.a_string;

public class Application01 {
    public static void main(String[] args) {
        /*
        * comment
        *  자료형은 크게 2가지 종류가 있다.
        *  1. 기본 자료형 (ex: int, double, boolean 등)
        *  2. 참조 자료형
        *  3. 사용자 정의의 자료형*/

        /*
        * comment
        *  String에서 사용되는 다양한 메소드*/
        String str1 = "apple";

        //length(): 길이
        //charAt(index(전달인자)): 문자열을 문자로 변환(인덱스: 0부터 시작)

        System.out.println(str1.length());

        //"apple" -> 'a', 'p', 'p' 이런 식으로 분리
        for(int i = 0; i < str1.length(); i++) {//초기식;조건식;증감식 / 조건식의 부등호에서 등호를 포함하지 않는다.(0부터 시작하기 때문에)
            System.out.println("charAt(" + i + "): " + str1.charAt(i));

        }

        String trimStr = "   java   "; //앞 뒤 공백 3번씩
        System.out.println("공백 자르기 전 확인: #" + trimStr + "#");//공백 확인용
        System.out.println("공백 자른 후 확인: #" + trimStr.trim() + "#");//공백 확인용
    }
}
