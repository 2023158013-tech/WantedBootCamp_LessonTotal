package com.wanted.cache.cache;

import java.util.Locale;

//jr. 외부에서 바뀌면 안되므로 final 키워드 추가
public final class CacheKeys {
//jr. 강사님 제공 코드

    /*comment
    *  캐시는 Key가 존재하며, Key가 같으면 같은 캐시 항목으로 취급된다.
    *  jr. Cache[캐시 데이터1[] 2[] 3[]]<- 외부[]: 외부에서 캐시 데이터에 접근할 때 Key라는 식별자를 사용해서 접근한다.
    *  */

    private CacheKeys() {
    }

    /*comment
    *  ex) popular::food::2000::12000 -> 이렇게 1개의 key를 생성한다.
    *  ex) popular::food::2000::10000 -> 이렇게 1개의 key를 생성한다.
    *  ex) popular::*::2000::10000 -> 이렇게 1개의 key를 생성한다.
    *  jr. 카테고리 미지정의 경우 * 로 표현한다.
    *  jr. =>(maximum만 10000으로 바꿈) -> 두개의 예시는 다른 것) 하나의 검색 조건만 달라도 key값이 달라진다.
    *  jr. 검색 조건을 4개 다 넣을 수도 있고 아닐 수 있음*/
    public static String search(String keyword, String category, Integer minPrice, Integer maxPrice) {
        return normalize(keyword) + "::" + normalize(category) + "::" + value(minPrice) + "::" + value(maxPrice);
    }


    private static String normalize(String value) {
        if (value == null || value.isBlank()) {
            return "*";
        }
        return value.trim().toLowerCase(Locale.ROOT);
    }

    private static String value(Integer value) {
        return value == null ? "*" : String.valueOf(value);
    }
}
