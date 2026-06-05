package com.wanted.cleanarchitecture.learning.application.policy;

import com.wanted.cleanarchitecture.enrollment.domain.repository.EnrollmentRepository;
import com.wanted.cleanarchitecture.global.domain.common.exception.DomainRuleViolationException;
import org.springframework.stereotype.Component;

/*
 * LearningAccessPolicy는 학습 진행 가능 여부를 판단하는 Application Policy다.
 *
 * 현재 코드는 수업 실습을 위해 일부러 enrollment의 Repository를 직접 사용한다.
 * 앞에서 완성한 CourseCatalogPort 예제를 참고해 다음 단계에서
 * learning.application.port.EnrollmentAccessPort로 분리해보면 된다.
 *
 * TODO:
 * - EnrollmentRepository 직접 의존을 제거한다.
 * - EnrollmentAccessPort를 주입받는다.
 * - "활성 수강이 있는가?"라는 결과만 사용하도록 바꾼다.
 */
@Component
public class LearningAccessPolicy {

    private final EnrollmentRepository enrollmentRepository;

    public LearningAccessPolicy(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public void ensureModuleCompletable(Long userId, Long courseId) {
        enrollmentRepository.findActiveEnrollment(userId, courseId)
                .orElseThrow(() -> new DomainRuleViolationException("Active enrollment is required before learning."));
    }
}
