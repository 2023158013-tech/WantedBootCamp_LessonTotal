package com.wanted.polymorphism.a_polymorphism;

public class Application01 {
    public static void main(String[] args) {

        /* comment.
         *   다형성이란?(polymorphism)(문자열보다 사용 범위가 넓어짐)
         *   하나의 인스턴스가 여러가지의 타입을 가질 수 있는 것을 의미한다.
         *   그렇기 때문에 하나의 타입으로 여러 타입의 인스턴스를 처리할 수 있고
         *   하나의 메소드 호출로 객체별 다른 방법으로 동작하게 할 수 있다.
         *  */

        System.out.println("==================Animal=====================");
        Animal animal = new Animal();
        animal.eat(); //animal이 가진 메소드 하나하나 호출
        animal.run();
        animal.bark();
        System.out.println("==================Animal=====================");

        //라쿤 메소드 하나하나 호출
        System.out.println("==================Raccoon=====================");
        Raccoon raccoon = new Raccoon();
        raccoon.eat();
        raccoon.run();
        raccoon.bark();
        raccoon.bite(); //라쿤만의 기능
        System.out.println("==================Raccoon=====================");

        //코알라 메소드 하나하나 호출
        System.out.println("==================Koala=====================");
        Koala koala = new Koala();
        koala.eat();
        koala.run();
        koala.bark();
        koala.sleep(); //코알라만의 기능
        System.out.println("==================Koala=====================");

        /* Is - A 관계 */ //너구리는 동물이다(o), 동물은 너구리다(x)
        //동물(공간) = 개구리(값) (왼쪽부터 읽게 되면 '동물은 개구리다'라고 읽게됨)<대입 연산자의 특성>을 생각
        //->개구리라는 값은 동물이라는 공간에 들어가는 것이기 때문에 맞음.
        Animal a1 = new Raccoon(); //다형성이 적용됨. 라쿤은 라쿤임과 동시에 동물이다.(동물의 기능, 본인의 기능을 모두 사용 가능)(상속과 연관됨)
        Animal a2 = new Koala();

        // 안 되는 구문(라쿤은 동물에 포함되는 것이지 동물을 대변할 수 없음)
//        Raccoon r1 = new Animal();

        /*컴파일 시점과 런타임 시점
        * 컴파일 시점: 우리가 코드를 치는 이 순간(잘못 쳐서 오류 뜨는 것이 컴파일 오류임)
        * 런타임 시점: 말그대로 프로젝트를 실행할 때(실행했는데 코드가 쭉 읽혀지면서 에러가 나면 런타임 에러)
        * a1의 작성 당시의 자료형은 animal이지만 런타임을 하면 힙 메모리의 u키워드를 만나서 라쿤값이 들어감(런타임 시점)*/
        /* comment. 동적바인딩(바인딩: 한 곳에 있다가 다른 곳으로 건너뜀(컴파일 시점: animal, 런타임 시점: 라쿤)
         *   컴파일 시점에는 해당 타입의 메소드와 연결 되어 있다가
         *   런타임 시점에 실제 객체가 가진 오버라이딩 된 메소드(koala , raccoon)로 변경되어
         *   동작하는 것을 의미한다.
         *  */
        System.out.println("=================동적 바인딩 확인===================");
        a1.bark(); //a1과 a2의 자료형은 animal임. "동물이 울부짖습니다"가 출력돼야하는데 실제로는 라쿤, 코알라 객체의 bark가 동작함.<동적 바인딩>
        a2.bark();

        // 실제 타입은 animal 이기 때문에 raccoon 의 고유 기능은 사용 불가
//        a1.bite();

        System.out.println("===============클래스 형변환=====================");
        ((Raccoon) a1).bite(); //animal은 깨물기 기능이 없기 때문에 라쿤으로 형변환(alt+enter)(상속 관계가 있어야지만 할 수 있음)
        ((Koala) a2).sleep(); //이렇게 하면 라쿤은 동물이 가진 기능도 모두 사용할 수 있게 됨
    }

}
