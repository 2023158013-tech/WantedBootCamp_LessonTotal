package com.wanted.cache.product;

import java.util.List;

public record ProductResponse(
        //jr. 강사님 제공 코드
        String keyword,
        String category,
        Integer minPrice,
        Integer maxPrice,
        int totalCount,
        List<Product> products
) {
}
