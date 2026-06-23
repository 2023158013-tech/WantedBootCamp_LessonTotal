package com.wanted.cache.product;

import com.wanted.cache.cache.CacheNames;
import com.wanted.cache.support.SlowSimulator;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.*;
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

    //CachePut은 캐시 히트 여부와 관계 없이 메서드 본문을 실행한다.
    //jr. 기존 캐시 갱신: 기존 데이터에 접근하기 위해선 key가 필요함(이거보단 캐시 삭제가 더 중요함)
    @CachePut(key = "#id")
    public Product refreshProduct(Long id) {
        slowSimulator.detailQueryLatency();
        return findProduct(id);
    }

    //id값에 해당하는 캐시 데이터를 무효화(제거)한다.
    //jr. 키값을 적어서 어떤 캐시 데이터를 삭제할지 지정
    @CacheEvict(key = "#id")
    public void evictProduct(Long id) {
        //jr. 특별히 뭐 할 거 없이 딱 무효화만 해보기
    }

    /*comment
    *  @Caching은 여러 캐시 작업을 한 번에 묶을 수 있다.
    *  재고 변경 등에 의한 캐시 재설정은 put보다는 evict를 사용해서 기존 캐시를 날리고 새롭게 만드는 방법을 훨씬 많이 쓰게 된다.
    *  evict allEntries = true는 PRODUCT_SEARCH  캐시 전체를 비우는 명령어이다.
    *  해당 명령어는 단순하고 안전하지만, PRODUCT_SEARCH 캐시가 많을수록 재생성 비용이 커질 수 있다.(Trade-off 발생)
    *  jr. ↑한번에 지우고 오래된 데이터를 보여줄 가능성이 없기 때문에(DB와 캐시의 싱크가 안맞을 일이 없음).
    *  jr. 덮어쓰는건 제대로 됐는지 잘 모르기 때문에 아예 날리고 다시 넣음(evict) - 초기화하면 다시 다 깔아야하는 트레이드오프*/
    @Transactional //DML구문: 상품 재고 변경
    @Caching(
            put = @CachePut(key = "#id"), //jr. 위에 작성한 @CachePut의 키값을 덮어 씌움
            evict = @CacheEvict(cacheNames = CacheNames.PRODUCT_SEARCH, allEntries = true) //jr. 캐시 무효화로 공간 자체를 날림
            //jr. allEntries: 맥시멈 사이즈를 만들면 캐시 공간에 하나의 캐시 데이터를 엔트리라고 부름. 그 엔트리들을 전부 날리겠다는 의미.
    )
    public Product changeStock(Long id, int stock) {
        //jr. 재고 변경 전 먼저 변경할 상품 찾기
        //재고 변경을 위해 변경할 product 조회
        Product product = findProduct(id);

        //jr. setter 사용은 지양한다 -> 엔티티 내부에 메서드로 처리
        product.changeStock(stock);

        return product;
    }
}
