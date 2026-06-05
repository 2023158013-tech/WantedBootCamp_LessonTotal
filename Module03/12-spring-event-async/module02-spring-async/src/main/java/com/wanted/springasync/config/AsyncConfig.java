package com.wanted.springasync.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;

@EnableAsync
@Configuration
@EnableConfigurationProperties(AsyncProperties.class)
public class AsyncConfig implements AsyncConfigurer {

    private final AsyncProperties asyncProperties;

    public AsyncConfig(AsyncProperties asyncProperties) {
        this.asyncProperties = asyncProperties;
    }

    /*comment
    *  Executor는 @Async 메서드를 호출하면 호출한 쓰레드에서 실행하는 것이 아닌 Executor라는 실행자에게 작업을 위임한다.
    *  */
    @Bean(name = "classTaskExecutor")
    public Executor classtaskExecutor(AsyncProperties properties) {
        //비동기 메서드를 실행하는 워커 스레드 객체
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(properties.corePoolSize());
        //yml에서는 4로 입력함. 여기에 4를 적으면 우리의 스택이 외부 노출되므로 properties에서 선언한 변수 사용.
        executor.setMaxPoolSize(properties.maxPoolSize());
        executor.setQueueCapacity(properties.queueCapacity());
        executor.setThreadNamePrefix(properties.threadNamePrefix());
        //위까지는 yml에 작성한 변수 등록

        //APP 종료 시 이미 제출된 비동기 작업이 갑자기 끊기지 않도록 하는 설정
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //10초간 APP이 종료되어도 비동기 작업을 기다려준다.
        executor.setAwaitTerminationSeconds(10);

        executor.initialize(); //위에서 설정한 방식대로 초기화

        return executor;
    }

    @Nullable
    @Override
    public Executor getAsyncExecutor() {
        return classtaskExecutor(asyncProperties);
    } //위에 다 만들었기 때문에 없어도 되긴 함. (이 부분이 주석처리된다면 Async에 실행할 이름을 명확히 작성해야함)

    @Nullable
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new LoggingAsyncExceptionHandler();
    }

    @Slf4j //내부 클래스
    private static class LoggingAsyncExceptionHandler implements AsyncUncaughtExceptionHandler{
        //비동기 관련 예외 처리를 커스텀하는 내부 클래스 작성
        //void 형태의 비동기 메서드의 예외는 호출자에게 직접 전달할 방법이 없다.
        //고로, AsyncUncaughtExceptionHandler에서 별도로 로깅/알림/예외 처리를 해야 한다.

        @Override
        public void handleUncaughtException(Throwable ex, Method method, Object... params) {
            //ex: 예외 클래스, method: 메서드 시그니처, params: 뱉어내는 값이 있다면..
            log.error("[비동기 전용 예외 처리기] method = {}, params = {}, messages = {}",
                    method.getName(), Arrays.toString(params), ex.getMessage());
        }

    }
}
