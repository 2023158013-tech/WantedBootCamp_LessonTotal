package com.wanted.cleanarchitecture.catalog.domain.repository;

import com.wanted.cleanarchitecture.catalog.domain.model.CourseSection;

//섹션 추가
public interface SectionRepository {

    CourseSection save(CourseSection newSection);
}
