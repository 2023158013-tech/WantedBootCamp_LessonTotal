package com.wanted.cleanarchitecture.catalog.presentation.api.request;

//섹션 추가
public record AddSectionRequest(
        String title,
        int sectionOrder
) {
}
