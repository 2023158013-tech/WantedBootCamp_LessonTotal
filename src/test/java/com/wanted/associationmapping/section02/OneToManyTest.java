package com.wanted.associationmapping.section02;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToManyTest {

    @Autowired
    private OneToManyService service;

    @Test
    @DisplayName("1:N 연관관계 객체 그래프 탐색 조회")
    void oneToManyTest() {

        //given 카테고리 코드 10번을 전달하면 10번에 해당하는 메뉴들 전체 조회
        int categoryCode = 10;

        //10번 카테고리를 조회함과 동시에 그에 대한하는 Menu를 조회하는 테스트
        Category category = service.findCategory(categoryCode);

//        System.out.println("category.getMenuList() = " + category.getMenuList());
        System.out.println(category);

        Assertions.assertNotNull(category);

    }

}
