package com.wanted.cache.support;

import org.springframework.stereotype.Component;

//jr. 일부러 시간을 늦추기 위한 클래스(의도적 지연 클래스)

@Component //jr. bean 등록을 위한 어노테이션
public class SlowSimulator {
    //jr. 강사님 제공 코드

    //상세 조회용 의도적 지연 메서드
    //120ms 지연을 만든다.
    public void detailQueryLatency() {
        sleep(120);
    }

    //검색 조회용 의도적 지연 메서드
    //450ms 지연을 만든다.
    public void searchQueryLatency() {
        sleep(450);
    }

    //TreadSleep 메서드: 의도적으로 작업을 중단한다.
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Sleep Error 발생!", e);
        }
    }

}
