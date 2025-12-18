package com.ohgiraffers.section01.init;

public class Car {

    // 필드 (자동차의 속성)
    private String modelName;
    private int maxSpeed;

    // 생성자 (자동차를 처음 만들 때 필요한 값을 받아 초기화)
    public Car(String modelName, int maxSpeed) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    // 메소드 (자동차가 수행할 수 있는 동작)
    public void driveMaxSpeed() {
        System.out.println(this.modelName + "이(가) 최고시속 " + this.maxSpeed + "km/h로 달려갑니다.");
    }

    public String getModelName() {
        return modelName;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
