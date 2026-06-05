package com.wanted.springasync.section03.async_event;

import com.wanted.springasync.common.support.LectureResponse;
import com.wanted.springasync.domain.course.Enrollment;
import com.wanted.springasync.repository.course.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsyncEventService {

    private final EnrollmentRepository enrollmentRepository;
    private final ApplicationEventPublisher publisher; //spring쪽에서 제공해주는 것.
    private final CompletionSummaryService completionSummaryService;

    @Transactional
    public LectureResponse completeEnrollment(Long enrollmentId) {

        long start = System.currentTimeMillis();

        log.info("[section03] 수강 완료 요청 시작!! 작업을 처리 중인 Thread = {}", Thread.currentThread().getName());
        //현재 작업 중인 스레드 이름 확인(동기/비동기인지 보려고)

        Enrollment enrollment = enrollmentRepository.findDetailById(enrollmentId)
                .orElseThrow(() -> new IllegalArgumentException("수강 정보를 찾을 수 없습니다. id=" + enrollmentId));

        enrollment.complete();

        /*comment
         *  해당 서비스는 수료 서비스와 의존성을 분리하며 수강 완료라는 이벤트를 발행할 것이다.
         *  또한 해당 이벤트는 동기 방식으로 진행하지 않으며 비동기 방식으로 구성할 것이다.
         *  */
//        asyncNotificationService.sendCompletionEmail(enrollment);
        publisher.publishEvent(new CourseCompletedEvent(
                enrollment.getId(),
                enrollment.getUser().getId(),
                enrollment.getCourse().getTitle()
        ));

        log.info("[section03] 수강 완료 요청 종료!! 작업을 처리 중인 Thread = {}", Thread.currentThread().getName());

        return LectureResponse.completed(
                "section03_async-event",
                "핵심 트랜잭션만 처리하고 수료 이메일 발송은 이벤트 리스너에 위임.",
                start
        );

    }

    public CompletionSummaryResponse requestCompletionSummary(Long enrollmentId) {

        long start = System.currentTimeMillis();

        log.info("[section03] CompletableFuture 수강 완료 요청 시작!! 작업을 처리 중인 Thread = {}", Thread.currentThread().getName());

        /*comment
        *  thenAccept()의 흐름
        *  1. createSummaryAsync 메서드 호출 시 CompletableFuture 타입의 값을 즉시 받는다.
        *  2. thenAccept(매개변수 -> 실행식)으로 나중에 성공하면 실행될 코드를 작성한다.
        *  3. 현재 메인 요청 스레드는 콜백 실행을 기다리지 않고 메인 흐름을 계속 진행한다.
        *  4. 비동기 작업이 모두 완료되면 summary 값이 콜백 함수에 전달되고 그 때 로그가 출력된다.
        *  */

        //수강 완료 시 수강 완료 요약 정보 생성은 비동기로 진행한다.
        completionSummaryService.createSummaryAsync(enrollmentId).thenAccept(
                //비동기 결과 -> 비동기 결과가 도출되었을 때 실행할 비즈니스 로직(비동기 결과):
                //이런 식으로 활용할 수 있게 된다.
                summary -> log.info("[section03] CompletableFuture 콜백 실행. summary = {}, thread = {}",
                        summary, Thread.currentThread().getName())
        );

        log.info("[section03] CompletableFuture 수강 완료 요청 종료!! 작업을 처리 중인 Thread = {}", Thread.currentThread().getName());

        return CompletionSummaryResponse.accepted(
                "메인 흐름 완료. 비동기 수강 요약 생성은 백그라운드에서 계속 진행 중!",
                start
        );
    }

    public CompletionSummaryResponse waitCompletionSummary(Long enrollmentId) {

        long start = System.currentTimeMillis();

        log.info("[section03] CompletableFuture 수강 완료 요청 대기 시작!! 작업을 처리 중인 Thread = {}", Thread.currentThread().getName());

        //비동기 메서드 호출
        //비동기 메서드의 결과값을 담을 future 변수 선언
        CompletableFuture<String> future = completionSummaryService.createSummaryAsync(enrollmentId);
        //위 메서드의 thenAccept 구문과 타입 맞춰주기?

        /*comment
        *  join(): 현재 메인 흐름의 요청 스레드를 멈춰세우고 Future 결과가 채워질 때까지 기다린다.
        *  -즉, @Async 메서드의 결과가 도출될 때까지 기다린다고 생각하면 된다.
        *  -예외 처리 필수 아님
        *  ---
        *  get()은 예외 처리가 필수적이다.(지정한 초만큼 기다리다가 넘으면 Throw 가능)
        *  -실무에서는 join()을 활용하기 보다는 예외 처리가 강제적인 get(timeout, unit) 형식으로 작성해서 최대 대기 시간을 설정하여
        *  timeout 시 비동기 결과를 기다리지 않고 메인 흐름으로 넘어가는 방식으로 사용하게 된다. */
        String summary = future.join();

        log.info("[section03] CompletableFuture 수강 완료 요청 대기 종료!! 작업을 처리 중인 Thread = {}", Thread.currentThread().getName());

        return CompletionSummaryResponse.completed(
                "메인 흐름 완료. 비동기 수강 요약 생성을 join()으로 대기함!",
                summary,
                start
        );
    }
}
