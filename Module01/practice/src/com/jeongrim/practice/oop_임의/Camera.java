package com.jeongrim.practice.oop_임의;

public class Camera {
    private boolean isOn;
    private int videoLength;
    private boolean cameraOn;
    public void turnOn() {
        if (isOn) {
            System.out.println("휴대폰이 이미 켜져있습니다. 다음 동작을 실행해주세요.");
        } else {
            this.isOn = true;
            System.out.println("휴대폰을 켰습니다.");
        }
    }

    public void cameraOn() {
        if (isOn) {
            if (cameraOn) {
                System.out.println("카메라가 이미 실행되어 있습니다. 다음 동작을 실행해주세요.");
            } else {
                this.cameraOn = true;
                System.out.println("카메라를 실행했습니다.");
            }
        } else {
            System.out.println("휴대폰을 먼저 켜주세요.");
        }

    }

    public void photo() {
        if (cameraOn) {
            System.out.println("사진 촬영을 시작합니다. 치즈~~!");
        } else {
            System.out.println("카메라를 먼저 실행해주세요.");
        }
    }

    public void video() {
        if (cameraOn) {
            System.out.println("동영상 촬영을 시작합니다. 치즈~~!");
            this.videoLength += 10;
            System.out.println("동영상 길이: " + videoLength);
        } else {
            System.out.println("카메라를 먼저 실행해주세요.");
        }
    }
    public void turnOff() {
        if (isOn) {
            if (videoLength > 0) {
                videoLength = 0;
                isOn = false;
                System.out.println("동영상 촬영을 중지합니다.");
                System.out.println("휴대폰이 꺼집니다.");
            }
        } else {
            System.out.println("휴대폰이 이미 꺼져있습니다.");
        }
    }
}
