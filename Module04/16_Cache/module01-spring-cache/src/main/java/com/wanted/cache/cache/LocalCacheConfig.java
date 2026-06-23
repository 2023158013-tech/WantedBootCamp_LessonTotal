package com.wanted.cache.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

/*comment
*  @EnableCaching 어노테이션이 있어야 @Cacheable, @CachePut, @CacheEvict, @Caching 등 캐시 관련 어노테이션이 동작할 수 있다.
*  Spring은 해당 어노테이션이 붙은 메서드를 프록시로 감싸고 메서드 호출 전후에 캐시가 있는지를 확인한다.
*  */
@Configuration
@EnableCaching
public class LocalCacheConfig {

    //미리 만들어둔 CacheNames
    private static final List<String> CACHE_NAMES = List.of(
            CacheNames.PRODUCT_DETAIL,
            CacheNames.PRODUCT_SEARCH
    );

    //jr. CacheManager: 인터페이스로 구성된 Spring에서 제공하는 추상화 객체
    @Bean
    CacheManager cacheManager() {
        //CacheManager은 추상화 객체
        //실제 구현체는 CaffeineCacheManager로 구성한다.
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        //jr. 캐시 매니저를 통해 위에서 만든 CACHE_NAMES의 캐시 이름을 설정해준다.
        cacheManager.setCacheNames(CACHE_NAMES);

        //캐시 관련 설정
        cacheManager.setCaffeine(
                Caffeine.newBuilder()
                        //캐시 폭발을 방지하기 위해 최대 항목 수 지정(가장 조심해야 함)
                        .maximumSize(1_000)
                        //오래된 데이터(캐시)가 무한히 남지 않게 만료 시간(TTL)을 둔다.
                        .expireAfterAccess(Duration.ofMinutes(5))
                        //캐시 히트 비율, 미스 비율 등을 지표로 볼 수 있게 통계를 기록한다.
                        //Prometheus와 연동 가능
                        .recordStats() //jr. 저장해줘서 캐시 히트 비율 확인 가능
                        //크기 제한, 만료 등으로 제거된 캐시 항목을 관찰할 수 잇다.
                        //커스텀 메서드 사용 가능
                        .removalListener(((key, value, cause) ->
                                System.out.printf("cache removed: key=%s, cause=%s%n", key, cause)))
        );

        /*comment
        *  현재 cacheManager 설정은 모든 종류의 캐시가 5분 만료 시간을 가질 수 있다.
        *  하지만 캐시의 종류에 따라 TTL 설정은 달라져야 한다.
        *  */

        //jr. 커스텀 가능하다 ↓
//        cacheManager.registerCustomCache(
//                "PRODUCT_ALL",
//                Caffeine.newBuilder()
//                        .maximumSize(5_000)
//                        .expireAfterAccess(Duration.ofHours(5))
//                        .build()
//        );

        return cacheManager;
    }
}
