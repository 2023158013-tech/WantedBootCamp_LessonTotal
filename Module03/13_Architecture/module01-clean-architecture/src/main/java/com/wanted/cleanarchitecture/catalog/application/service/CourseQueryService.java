package com.wanted.cleanarchitecture.catalog.application.service;

import com.wanted.cleanarchitecture.catalog.application.usercase.CourseQueryUseCase;
import com.wanted.cleanarchitecture.catalog.domain.model.Course;
import com.wanted.cleanarchitecture.catalog.domain.repository.CourseRepository;
import com.wanted.cleanarchitecture.global.domain.common.exception.DomainRuleViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) //조회 관련 로직만 싹 모을 것
@RequiredArgsConstructor
public class CourseQueryService implements CourseQueryUseCase {

    private final CourseRepository courseRepository;

    //강의 상세 조회
    @Override
    public CourseView handle(Long courseId) {
        Course foundCourse = courseRepository.findById(courseId).orElseThrow(
                () -> new DomainRuleViolationException(courseId + "에 해당하는 강의를 찾을 수 없습니다.")
        );

        //course>section>module
        //모듈이 몇 개인지 카운트하는 로직↓
        int moduleCount = foundCourse.getSections().stream()
                .mapToInt(section -> section.getModules().size())
                .sum();

        return new CourseView(
                foundCourse.getId(),
                foundCourse.getAuthorId(),
                foundCourse.getTitle(),
                foundCourse.getDescription(),
                foundCourse.getStatus().name(),
                foundCourse.getSections().size(),
                moduleCount
        ); //foundCourse를 그대로 리턴하면 도메인 객체가 노출되는 것
    }
}
