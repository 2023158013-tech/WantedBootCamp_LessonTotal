package com.wanted.cleanarchitecture.catalog.presentation.api;

import com.wanted.cleanarchitecture.catalog.application.command.AddSectionCommand;
import com.wanted.cleanarchitecture.catalog.application.command.CreateCourseCommand;
import com.wanted.cleanarchitecture.catalog.application.usercase.CourseCommandUseCase;
import com.wanted.cleanarchitecture.catalog.application.usercase.CourseQueryUseCase;
import com.wanted.cleanarchitecture.catalog.infrastructure.persistence.CourseJpaEntity;
import com.wanted.cleanarchitecture.catalog.presentation.api.request.AddSectionRequest;
import com.wanted.cleanarchitecture.catalog.presentation.api.request.CreateCourseRequest;
import com.wanted.cleanarchitecture.catalog.presentation.api.response.CreateCourseResponse;
import com.wanted.cleanarchitecture.global.presentation.api.common.ApiResponse;
import com.wanted.cleanarchitecture.global.presentation.api.common.ApiResponseCode;
import com.wanted.cleanarchitecture.global.presentation.api.common.ApiResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    //command(dml)
    private final CourseCommandUseCase courseCommandUseCase;
    //query(read): 조회용
    private final CourseQueryUseCase courseQueryUseCase;

    //5-1. 강의 생성
    @PostMapping
    public ResponseEntity<ApiResponse<CreateCourseResponse>> createCourse(@RequestBody CreateCourseRequest request) {

        Long courseId = courseCommandUseCase.hande(new CreateCourseCommand(
                request.authorId(),
                request.title(),
                request.description()
        ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(
                        ApiResponseCode.COURSE_CREATED,
                        ApiResponseMessage.COURSE_CREATED,
                        new CreateCourseResponse(courseId)
                ));
    }

    //5-2. 강의 조회
    @GetMapping("/{courseId}")
    public ResponseEntity<ApiResponse<CourseQueryUseCase.CourseView>> getCourse(@PathVariable Long courseId) {

        return ResponseEntity.ok(ApiResponse.success(
                ApiResponseCode.SUCCESS,
                ApiResponseMessage.SUCCESS,
                courseQueryUseCase.handle(courseId)

        ));
    }

    //5-3. 섹션 추가
    @PostMapping("/{courseId}/sections")
    public ResponseEntity<ApiResponse<Void>> addSection(@PathVariable Long courseId, @RequestBody AddSectionRequest request) {

        Long savedCourseId = courseCommandUseCase.handle(new AddSectionCommand(
                courseId,
                request.title(),
                request.sectionOrder()
        ));

        return ResponseEntity.ok(ApiResponse.success(
                ApiResponseCode.SUCCESS,
                ApiResponseMessage.SUCCESS
                )
        );
    }

}
