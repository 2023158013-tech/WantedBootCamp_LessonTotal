package com.wanted.b_collection.c_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Application01 {
    public static void main(String[] args) {
        /*comment
        *  Map의 자료구조를 이해하고 HashMap을 사용해보자.
        *  Map의 가장 기억해야 하는 특징
        *  1. K-V 키-값 한 쌍으로 데이터를 저장한다.
        *  2. K 키는 Set 자료 구조를 활용하여 구성되어 있으며 중복이 허용되지 않는다.
        *  */

        Map map = new HashMap();
        
        //put() 값을 넣는다.
        map.put("one", new Date());
        map.put(12, "red Apple");
        //키 값이 중복되게 되면, 기존 값이 나중에 작성한 값으로 덮여씌여지게 된다.
        map.put(12, true);
        map.put(11, true);

        System.out.println("map = " + map);

        //Map 자료구조에 담긴 값을 꺼낼 때는 Key를 활용한다.
        //get(Key);
        System.out.println("11-true 값 꺼내기: " + map.get(11));
        
        Map<String, String> map2 = new HashMap<>();
        map2.put("one", "java");
        map2.put("two", "db");
        map2.put("three", "jdbc");

        System.out.println("map2 = " + map2);
    }
}
