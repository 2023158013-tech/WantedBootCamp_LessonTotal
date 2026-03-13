package com.wanted.crud.course.controller;

import com.wanted.crud.course.model.dto.CourseDTO;
import com.wanted.crud.course.model.service.CourseService;

import java.util.List;

public class CourseController {

    /*comment
    *  Controller 계층의 책임
    *  -Controller는 View와 Service 사이를 연결하는 커멘드 센터
    *  -View가 사용자에게 입력을 받고, 그 입력을 Controller에게 전달하면 Controller는 적절한 Service 계층의 메소드를 호출한다.
    *  Controller가 해야할 일
    *  -1. View에서 받은 요청을 처리하는 메소드
    *  -2. Service 메소드 호출 코드
    *  -3. 필요하다면 DTO 혹은 그 외의 객체를 조립하는 코드
    *  Controller가 하면 안되는 일
    *  -1. Scanner 입력 처리 (View에서 모두 담당함)
    *  -2. 출력 처리
    *  -3. SQL 작성
    *  -4. Commit/Rollback 작업
    *
    * */

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    public boolean updateCourse(long id, String title, String description) {
        return true;
    }

    public List<CourseDTO> findAllCourses() {
        return service.findAllCourses();
    }
}
