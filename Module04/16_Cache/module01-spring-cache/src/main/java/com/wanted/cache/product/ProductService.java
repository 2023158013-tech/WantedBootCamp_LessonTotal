package com.wanted.cache.product;

import com.wanted.cache.cache.CacheNames;
import com.wanted.cache.support.SlowSimulator;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
//해당 어노테이션은 이 서비스에서 반복 사용하는 기본 캐시 이름을 Class Level에 지정해 메서드마다 중복될 수 있는 문자열을 줄이는 용도로 사용한다.
//jr. 원래라면 메서드마다 캐시 이름을 만들어줘야하지만 클래스 레벨이 한 번 사용해서 중복을 줄인다.
@CacheConfig(cacheNames = CacheNames.PRODUCT_DETAIL)
public class ProductService {
//jr. 강사님 제공 코드
    private final ProductRepository productRepository;
    private final SlowSimulator slowSimulator;

    public Product getProductBefore(Long id) {

        //의도적 지연을 발생 시킴
        slowSimulator.detailQueryLatency();

        return findProduct(id);
    }

    //jr. 헬퍼 메서드
    //id로 조회용 헬퍼 메서드
    private Product findProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID가 없습니다!"));
    }

    public ProductResponse searchBefore(String keyword, String category, Integer minPrice, Integer maxPrice) {

        slowSimulator.searchQueryLatency();

        return searchProducts(keyword, category, minPrice, maxPrice);
    }

    //jr. 헬퍼 메서드
    private ProductResponse searchProducts(String keyword, String category, Integer minPrice, Integer maxPrice) {

        List<Product> products = productRepository.search(blankToNull(keyword), blankToNull(category), minPrice, maxPrice);

        return new ProductResponse(keyword, category, minPrice, maxPrice, products.size(), products);
    }

    //검색 조건이 비어서 올 때(빈 문자열) null로 변환해서 반환해주는 헬퍼 메서드
    private String blankToNull(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return value.trim();
    }

    //캐시 적용 후--------
    //상세 조회에 캐시 추가
    //key: 메서드 파라미터인 id 변수를 캐시 접근 key로 사용하겠다는 의미
    //condition: 메서드 실행 전에 평가되며 id가 0 이하이면 캐시를 사용하지 않는다.(조건 설정 부분)
    //jr. 캐시는 자주 바뀌면 안된다
    //unless: 메서드 실행 후에 평가되며 결과값이 null이면 캐시를 사용하지 않는다.
    //jr. 결과값이 null이면 캐시로 저장하지 않는다.
    @Cacheable(key = "#id", condition = "#id > 0", unless = "#result == null")
    public Product getProductAfter(Long id) {
        //의도적 지연
        //jr. before 내부를 그대로 복붙
        slowSimulator.detailQueryLatency();

        return findProduct(id);
    }

    //검색으로 상품 조회하기(jr.매개변수부에 있는 변수들은 있어도 되고 없어도 되는 검색 조건)
    @Cacheable(
            cacheNames = CacheNames.PRODUCT_SEARCH,
            //jr. 클래스 레벨에 적은 캐시 이름과 다른 이름을 적용하니까 따로 작성해야함.
            key = "T(com.wanted.cache.cache.CacheKeys).search(#keyword, #category, #minPrice, #maxPrice)",
            //jr. 클래스 자료형에서 메서드 호출
            condition = "#keyword != null && #keyword.length() >= 2", //검색어 2글자 이하로 키를 만들면 키가 너무 많아질 수 있다.
            //jr. 붕어싸만코 검색 시 붕, 붕어, 붕어싸 이런식으로 붕만으로 검색해도 붕어싸만코가 나온다면 부하?
            unless = "#result.totalCount() == 0" //jr. 아무것도 검색되지 않으면 캐시 미사용
    )
    public ProductResponse searchAfter(String keyword, String category, Integer minPrice, Integer maxPrice) {
        //의도적 지연
        slowSimulator.searchQueryLatency();

        return searchProducts(keyword, category, minPrice, maxPrice);
    }
}
