package com.wanted.section02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class EntityManagerCRUD {

    private static EntityManagerFactory factory;
    private EntityManager manager;

    @BeforeAll
    static void initFactory() {
        factory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void initManager() {
        manager = factory.createEntityManager();
    }

    @AfterEach
    void closeManager() {
        manager.close();
    }

    @AfterAll
    static void closeFactory() {
        factory.close();
    }

//    Menu menu = new Menu();
    
    @Test
    @DisplayName("메뉴 코드로 메뉴 조회하기")
    void findMenuByMenuCode() {
       
        //give(값 주기)사용자 입력
        int menuCode = 2;
        
        //when(조건 주기)비즈니스 로직
        Menu foundMenu = manager.find(Menu.class, 2);
        
        //then(결과 확인)서비스 로직의 결과 예측
        Assertions.assertNotNull(foundMenu);
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());

        System.out.println("foundMenu = " + foundMenu);
    }

    @Test
    @DisplayName("새로운 메뉴 추가 테스트")
    void testInsertNewMenu() {

        //give
        Menu newMenu = new Menu();
        newMenu.setMenuName("JPA 테스트 메뉴");
        newMenu.setMenuPrice(15000);
        newMenu.setCategoryCode(4);
        newMenu.setOrderableStatus("Y");

        //when
        EntityTransaction transaction = manager.getTransaction();

        //DB에 실제로 반영하기 위해 transaction 시작!
        transaction.begin();

        try {
            manager.persist(newMenu);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        //then
        Assertions.assertTrue(manager.contains(newMenu));

    }

    @Test
    @DisplayName("메뉴 이름 수정 테스트")
    void updateMenuName() {

        //given(수정 대상 엔티티를 가져옴)
        Menu menu = manager.find(Menu.class, 2);
        System.out.println("menu = " + menu);

        String changeName = "아이스 아메리카노 얼음 많이 연하게";

        //when
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        try {
            menu.setMenuName(changeName);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        //then
        Assertions.assertEquals(changeName, manager.find(Menu.class, 2).getMenuName());

    }

    @Test
    @DisplayName("메뉴 삭제하기 테스트!")
    void deleteMenu() {

        Menu removeMenu = manager.find(Menu.class, 24);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        try {
            manager.remove(removeMenu);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        Menu removedMenu = manager.find(Menu.class, 24); //위에서 삭제가 정상적으로 되면 이 구문은 null이 됨

        Assertions.assertNull(removedMenu);

    }

}
