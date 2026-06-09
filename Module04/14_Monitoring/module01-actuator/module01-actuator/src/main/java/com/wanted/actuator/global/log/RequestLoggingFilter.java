package com.wanted.actuator.global.log;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

/*comment
*  Metric과 Log를 어떤 식으로 분류해서 사용할까?
*  -메트릭으로 이상을 발견하고 로그로 원인을 좁혀간다.
*  -(내 생각)메트릭은 사용자를 위한 지표 수집, 로그는 개발자 중심의 오류 파악으로 빠른 개발과 흐름 파악에 도움
*  - 메트릭은 "오류가 몇 번 발생했는가?", "응답 시간이 얼마나 늘었는가?" 등에 대한 집계된 숫자에 강하다
*  하지만 사용자의 요청 하나가 어떤 비즈니스 로직을 지나가며 왜 실패했는지를 메트릭으로는 알기 어려운 한계가 있다.
*  이러한 한계는 Log로 극복한다.
*  */

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    //롬복 미설치로 로그 직접 설정
    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

    public static final String REQUEST_ID_HEATER = "X-Request-Id";
    public static final String TRACE_ID_MDC_KEY = "trace-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String traceId = resolveTraceId(request);

        //시작 시간 측정
        long startAt = System.nanoTime();

        MDC.put(TRACE_ID_MDC_KEY, traceId);

        response.setHeader(REQUEST_ID_HEATER, traceId);

        try {

            //해당 값이 나중에 LogQL에서 조회 Where 조건에 해당한다.(event=request_started): 보고자 하는 로그만 모아보기 위한 이름("라벨"≒컬럼)
            log.info("event=request_started method={} uri={}", request.getMethod(), request.getRequestURI());

            //해당 과정 끝나면 다음 필터로 넘기기
            //다음 필터 동작, 없으면 Controller
            filterChain.doFilter(request, response);
        } finally {

            //소요 시간 계산
            long durationMs = (System.nanoTime() - startAt) / 1_000_000;

            log.info(
                    "event=request_completed method={} uri={} status={} durationMs={}",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    durationMs
            );

            MDC.remove(TRACE_ID_MDC_KEY);
        }
    }

    //UUID 생성 메서드
    private String resolveTraceId(HttpServletRequest request) {

        //사용자 요청 헤더에서 requestId 꺼내기
        String requestId = request.getHeader(REQUEST_ID_HEATER);

        //없으면 UUID, 있으면 사용자 요청에서 꺼내기
        if(requestId == null || requestId.isBlank()) {

            return UUID.randomUUID().toString();
        }
        //요청별 식별 Id 반환
        return requestId;
    }
}
