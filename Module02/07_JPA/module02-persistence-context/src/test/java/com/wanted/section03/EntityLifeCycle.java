package com.wanted.section03;

import com.wanted.section02.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityLifeCycle {

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

    @Test
    void 비영속_테스트_메서드() { //테스트 메서드에서는 displayName 대신 한글로 작성하기도 함.

        /*comment
        *  객체를 생성하면(new) 영속성 컨텍스트와는 전혀 관련엾는 비영속 상태이다.
        *  */

        //given
        Menu foundMenu = manager.find(Menu.class, 1);
        Menu newMenu = new Menu();
        newMenu.setMenuCode(foundMenu.getMenuCode());
        newMenu.setMenuName(foundMenu.getMenuName());
        newMenu.setMenuPrice(foundMenu.getMenuPrice());
        newMenu.setCategoryCode(foundMenu.getCategoryCode());
        newMenu.setOrderableStatus(foundMenu.getOrderableStatus());
        //자료형 같고, 값도 똑같음.

        //when
        boolean isTrue = (foundMenu == newMenu);

        //then
        Assertions.assertFalse(isTrue); //isTrue가 false면 테스트 통과(foundMenu와 newMenu가 서로 다름)

    }

    @Test
    void 영속성_테스트_메서드() {

        //given
        Menu foundMenu = manager.find(Menu.class, 1);
        Menu newMenu = manager.find(Menu.class, 1);

        //when
        boolean isTrue = (foundMenu == newMenu);

        //then
        Assertions.assertTrue(isTrue); //isTrue가 false면 테스트 통과(foundMenu와 newMenu가 서로 같음)
                                       //asserTrue로 했을 때 테스트 통과함(find 한 번 동작함. 이전 쿼리를 기억해서)
    }

    @Test
    void 준영속_detach_테스트() {

        //given
        Menu foundMenu1 = manager.find(Menu.class, 11);
        Menu foundMenu2 = manager.find(Menu.class, 12);

        //when
        manager.detach(foundMenu2);
        foundMenu1.setMenuPrice(5000);
        foundMenu2.setMenuPrice(5000);

        //then
        assertEquals(5000, manager.find(Menu.class, 11).getMenuPrice()); //통과
//        assertEquals(5000, manager.find(Menu.class, 12).getMenuPrice());

    }

    @Test
    void 삭제_remove_테스트() {
        /*comment
        *  remove(): 엔티티를 영속성 컨텍스트 및 DB에서 삭제한다.
        *  단, 트랜잭션을 제어하지 않으면 영구 반영되지 않는다.
        *  */

        Menu foundMenu = manager.find(Menu.class, 2);

        manager.remove(foundMenu);

        Menu refoundMenu = manager.find(Menu.class, 2);

        assertEquals(2, foundMenu.getMenuCode());
        assertEquals(null, refoundMenu); //통과됨. refoundMenu가 널

    }

    @Test
    void 병합_merge_수정_테스트() {
        Menu detachMenu = manager.find(Menu.class, 2);
        manager.detach(detachMenu);

        detachMenu.setMenuName("보쌈");
        Menu refoundMenu = manager.find(Menu.class, 2);

        System.out.println("detachMenu = " + detachMenu.hashCode());
        System.out.println("refoundMenu = " + refoundMenu.hashCode());

        manager.merge(detachMenu);

        Menu mergeMenu = manager.find(Menu.class, 2);
        System.out.println("mergeMenu = " + mergeMenu.hashCode());

        assertEquals("보쌈", mergeMenu.getMenuName());
    }
}
