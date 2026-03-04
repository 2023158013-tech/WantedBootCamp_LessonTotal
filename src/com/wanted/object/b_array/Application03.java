package com.wanted.object.b_array;

public class Application03 {
    public static void main(String[] args) {
        //출력 예시: 당신이 뽑은 카드는 SPADE ACE입니다!
        //필요한 값: 카드넘버, 문양
        
        String[] shapes = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};
        
        //Math 클래스 -> 수학적 요소(합계, 평균, 올림, 내림 등등)
        //우리같은 수학을 싫어하는 사람들을 위해 개발자들이 미리 만들어둠.
        int randomShape = (int) (Math.random() * shapes.length); //Math.random: 0~1 사이의 난수 생성(실수 반환하므로 형변환해야함)
                                                                 // 여기에 배열 길이만큼 곱해줌
        System.out.println("randomShape = " + randomShape);
        int randomNumber = (int) (Math.random() * numbers.length);
        System.out.println("randomNumber = " + randomNumber); //인덱스 방번호를 랜덤하게 추출한 것

        System.out.println("당신이 뽑은 카드는 " + shapes[randomShape] + " " + numbers[randomNumber] + "입니다!!");
    }
}
