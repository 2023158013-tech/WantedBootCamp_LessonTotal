package com.wanted.oop.d_constructor.use;

//import com.wanted.oop.d_constructor.UserDTO;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {

        /*comment
        *  생성자를 이용한 초기화, 설정자를 이용한 초기화
        *  1. 생성자를 이용한 초기화
        *  -장점: setter 메소드를 여러 번 호출해서 사용하지 않고 한 번의 호출로 객체 생성 및 초기화를 진행할 수 있다.
        *  -단점: 호출 시 인자가 많은 경우 어떤 값이 어떤 필드를 의미하는지 알기 힘들다.
        *  2. 설정자(setter)를 이용한 초기화
        *  -장점: 필드를 초기화하는 각각의 값들이 어떤 필드를 초기화하는지 명확히 볼 수 있다.
        *  -단점: 하나의 인스턴스를 생성할 때, 한 번의 호출로 끝나지 않는다.*/

        //전달 인자 많으면 복잡
        UserDTO user = new UserDTO("user01", "pass01", "서정림", LocalDateTime.now());
        System.out.println("user = " + user);;

        //어떤 필드에 어떤 값을 넣는지 확실함
        UserDTO user2 = new UserDTO();
        user2.setId("user02");
        user2.setPwd("pass02");
        user2.setName("서정림");
        user2.setEnrollData(LocalDateTime.now());
        System.out.println("user2 = " + user2);
    }
}
