package com.wanted.cleanarchitecture.catalog.application.usercase;

import com.wanted.cleanarchitecture.catalog.application.command.AddSectionCommand;
import com.wanted.cleanarchitecture.catalog.application.command.CreateCourseCommand;
import com.wanted.cleanarchitecture.catalog.infrastructure.persistence.CourseJpaEntity;

import java.util.List;

public interface CourseCommandUseCase {

    //실제 어플리케이션 비즈니스 로직 실행
    Long hande(CreateCourseCommand command);

    //섹션 추가
    Long handle(AddSectionCommand command);

}
