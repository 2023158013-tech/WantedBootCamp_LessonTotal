package com.wanted.springevent.section02.event;
//≒DTO

/*comment
*  record란?
*  DTO(데이터 운반)와 동일한 역할을 한다.
*  but, 레코드는 불변객체이다.
*  -()(소괄호) 내부에 작성하는 필드에는 자동으로 final 처리가 된다.
*  아무것도 하지 않더라도 자동 추가되는 구문은 아래와 같다.
*  -생성자
*  -getter(setter는 자동 추가되지 않음. record는 읽기 전용임.)
*  -equals
*  -hashcode
*  -toString
*  ∴ record는 DTO와 역할이 동일하다(데이터 운반 전용)
*  -DTO와의 가장 큰 차이점은 불변 객체라고 하는 것과 읽기 전용 객체라고 하는 것이다.*/

public record Section02CourseCompletedEvent(
        Long enrollmentId,
        Long userId,
        String userName,
        Long courseId,
        String courseTitle
) {
}
