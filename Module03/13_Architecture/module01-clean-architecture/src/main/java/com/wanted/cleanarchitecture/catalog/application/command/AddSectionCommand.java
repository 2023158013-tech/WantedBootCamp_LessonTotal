package com.wanted.cleanarchitecture.catalog.application.command;

//섹션 추가
public record AddSectionCommand(
        Long courseId,
        String title,
        int sectionOrder
) {
}
