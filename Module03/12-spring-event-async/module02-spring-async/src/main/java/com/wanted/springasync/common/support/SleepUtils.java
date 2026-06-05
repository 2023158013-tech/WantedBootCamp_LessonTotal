package com.wanted.springasync.common.support;

public final class SleepUtils {

    private SleepUtils() {
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis); //현재 스레드를 잠시 멈춤(일부러 멈추기) (ex. 3000 : 3초 동안 스탑)
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("sleep interrupted", exception);
        }
    }
}
