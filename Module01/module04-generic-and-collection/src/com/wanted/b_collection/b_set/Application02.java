package com.wanted.b_collection.b_set;

import java.util.Set;
import java.util.TreeSet;

public class Application02 {
    public static void main(String[] args) {

        /*comment
        *  TreeSet을 활용하여 로또 추첨기 만들기
        *  TreeSet 자료구조는 Set처럼 중복을 허용하지 않는다.
        *  일반적인 Set과는 달리 데이터가 정렬(순서 보장)된 상태로 이진 검색 트리 구조로 저장을 한다.
        *  따라서 데이터를 추가하거나 검색 혹은 제거하는 기본 동작이 매우 빠르다.(트리구조로 그린 그림을 생각하면 하나의 요소를 찾는데
        *  빠르게 접근 가능하다는 걸 알 수 있음)*/

        Set<String> stringSet = new TreeSet<>();
        stringSet.add("a");
        stringSet.add("c");
        stringSet.add("b");
        //Set의 기본적인 특징인 중복은 역시 허용되지 않는다.
        //다만, 데이터 정렬이 추가되었다.
        stringSet.add("b");
        stringSet.add("d");

        System.out.println("stringSet = " + stringSet);

        //1, 17, 24, 30, 37, 40, 43
        Set<Integer> lotto = new TreeSet<>();
        
        while(lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45) + 1);
        }

        System.out.println("lotto = " + lotto);
    }
}
