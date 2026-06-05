package com.wanted.cleanarchitecture.catalog.application.service;

import com.wanted.cleanarchitecture.catalog.application.command.AddSectionCommand;
import com.wanted.cleanarchitecture.catalog.application.command.CreateCourseCommand;
import com.wanted.cleanarchitecture.catalog.application.usercase.CourseCommandUseCase;
import com.wanted.cleanarchitecture.catalog.domain.model.Course;
import com.wanted.cleanarchitecture.catalog.domain.model.CourseSection;
import com.wanted.cleanarchitecture.catalog.domain.repository.CourseRepository;
import com.wanted.cleanarchitecture.catalog.domain.repository.SectionRepository;
import com.wanted.cleanarchitecture.global.domain.common.exception.DomainRuleViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional //단순 조회와 명령을 분리
public class CourseCommandService implements CourseCommandUseCase {

    private final CourseRepository courseRepository;
    //섹션 추가
    private final SectionRepository sectionRepository;

    @Override
    public Long hande(CreateCourseCommand command) {
        //주황색 딱지를 실행하는 코드가 작성됨(~됨)
        /* 내부 코드는 UseCase를 직접 수행하며 이벤트 스토밍 단계에서 DomainEvent(주황)를 수행한다.
        *  */

        //Course 기존 엔티티 -> 순수 Java 클래스
        //service 계층은 use case를 조립하고 transactional 경계만을 담당한다.
        //객체 생성은 해당 도메인 클래스 내부에서 진행하며 메소드로만 호출한다.

        //서비스 클래스에서 직접 new로 Course를 만들면 domain 계층을 침범하는 것이다.
        Course newCourse = Course.create(command.authorId(), command.title(), command.description());
        //↑command를 통해 하나의 course 객체 만들기
        Course savedCourse = courseRepository.save(newCourse);

        return savedCourse.getId(); //courseId 값 리턴
    }

    @Override
    public Long handle(AddSectionCommand command) {

        //course 존재하는지 먼저 조회
        Course course = courseRepository.findById(command.courseId()).orElseThrow(
                () -> new DomainRuleViolationException("존재하지 않는 강의입니다.")
        );

        //'DomainRuleViolationException' 검증 로직이 실행되도록 도메인에게 일을 시킵니다.(DRAFT 상태 체크, 순서 중복 체크)
        course.addSection(command.title(), command.sectionOrder());

        return course.getId();
    }
}
