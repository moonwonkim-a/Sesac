package com.ohgiraffers.section03.abstraction;

public class Car {

    // 캡슐화 : 자동차 내부 상태는 외부에서 직접 접근할 수 없도록 보호한다.
    private boolean isOn;   // 시동 상태
    private int speed;      // 현재 시속

    // 시동을 거는 기능
    public void startUp() {
        if (isOn) {
            System.out.println("이미 시동이 걸려 있습니다.");
        } else {
            this.isOn = true;
            System.out.println("시동을 걸었습니다. 출발할 준비 완료~!");
        }
    }

    // 앞으로 가는 기능
    public void go() {
        // 자동차는 자신의 상태(시동)을 스스로 확인하고 책임을 다한다.
        if (isOn) {
            System.out.println("차가 앞으로 움직입니다.");
            this.speed += 10;
            System.out.println("현재 시속은 " + this.speed + "km/h 입니다.");
        } else {
            System.out.println("시동을 먼저 걸어주세요~");
        }
    }

    // 멈추는 기능
    public void stop() {
        if (isOn) {
            if (this.speed > 0) {
                this.speed = 0;
                System.out.println("차가 서서히 멈춥니다.");
            } else {
                System.out.println("차는 이미 멈춰있는 상태입니다.");
            }
        } else {
            System.out.println("시동이 걸려있지 않습니다.");
        }
    }

    // 시동을 끄는 기능
    public void turnOff() {
        if(isOn) {
            if(speed > 0) {
                System.out.println("차를 먼저 멈춰주세요.");
            } else {
                this.isOn = false;
                System.out.println("시동을 끕니다. 운행을 종료합니다.");
            }
        } else {
            System.out.println("이미 시동이 꺼져 있는 상태입니다.");
        }
    }
}
