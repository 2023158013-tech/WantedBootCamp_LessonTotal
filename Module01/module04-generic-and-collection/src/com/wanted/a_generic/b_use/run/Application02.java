package com.wanted.a_generic.b_use.run;

import com.wanted.a_generic.b_use.*;

public class Application02 {
    public static void main(String[] args) {

        /*comment
        *  와일드 카드
        *  제네릭 클래스 타입의 객체를 메소드의 매개변수로 전달받을 때, 그 객체의 타입 변수를 제한할 수 있다.
        *  <?>: 제한 없음
        *  <? extends Type>: 와일드 카드 상한 제한
        *  <? super Type>: 와일드 카드 하한 제한*/

        WildcardFarm wfarm = new WildcardFarm();

        wfarm.anyType(new RabbitFarm<Rabbit>(new Rabbit())); //소괄호 안쪽부터 읽기
        wfarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wfarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        System.out.println("==========================================");

//        wfarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit())); //에러
        wfarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
        wfarm.extendsType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        System.out.println("==========================================");
        wfarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wfarm.superType(new RabbitFarm<Bunny>(new Bunny()));
//        wfarm.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny())); //에러
    }
}
