package com.wanted.springasync.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//읽기 전용으로 레코드 생성
@ConfigurationProperties(prefix = "app.async") //yaml의 app:\async: ~
public record AsyncProperties(
        /*comment
        *  yml에 작성한 async 관련 값을 변수 처리하여 활용하기 위함.
        *  케밥 케이스(ex. core-pool-size: 꼬챙이로 연결): 단어-단어(kebab-case)/ 카멜 케이스: camelCase
        *  */
        int corePoolSize,
        int maxPoolSize,
        int queueCapacity,
        String threadNamePrefix
) {



}
