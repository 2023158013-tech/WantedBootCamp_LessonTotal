package com.wanted.associationmapping.section02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OneToManyRepository {

    @PersistenceContext
    private EntityManager manager; //나중엔 매니저 없어도 자동으로 돌아감(내부적으로는 매니저가 열일)

    public Category find(int categoryCode) {

        return manager.find(Category.class, categoryCode);
    }
}
