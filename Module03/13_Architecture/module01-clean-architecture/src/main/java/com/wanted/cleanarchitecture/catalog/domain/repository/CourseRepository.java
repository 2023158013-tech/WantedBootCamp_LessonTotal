package com.wanted.cleanarchitecture.catalog.domain.repository;

import com.wanted.cleanarchitecture.catalog.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository {

    //새로운 강의 저장
    Course save(Course newCourse);

    //강의 아이디로 조회
    Optional<Course> findById(Long courseId);
}
