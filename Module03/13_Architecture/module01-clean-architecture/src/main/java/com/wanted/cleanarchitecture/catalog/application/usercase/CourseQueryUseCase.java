package com.wanted.cleanarchitecture.catalog.application.usercase;

public interface CourseQueryUseCase {

    //강의 상세 조회 유스케이스
    CourseView handle(Long courseId);

    //강의 상세 조회 시 응답 사용 객체
    record CourseView(
            Long courseId,
            Long authorId,
            String title,
            String description,
            String status,
            int sectionCount,
            int moduleCount
    ) {} //레코드: 경량 클래스(여기에도 만들 수 있음)
}
