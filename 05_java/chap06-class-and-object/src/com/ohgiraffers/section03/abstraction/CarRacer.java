package com.ohgiraffers.section03.abstraction;

public class CarRacer {
    // 자신의 자동차를 가지고 있다. (소유 관계)
    private final Car myCar = new Car();

    // 자동차에 시동을 걸도록 명령
    public void startUp() {
        // 시동 거는 방법은 모른다
        // 단지 자신의 자동차에게 시동을 걸라고 '요청(메세지 전송)'할 뿐이다.
        myCar.startUp();
    }

    // 엑셀 밟도록 명령
    public void stepAccelator() {
        myCar.go();
    }

    // 브레이크 밟도록 명령
    public void stepBreak() {
        myCar.stop();
    }

    // 시동을 끄도록 명령
    public void turnOff() {
        myCar.turnOff();
    }
}
