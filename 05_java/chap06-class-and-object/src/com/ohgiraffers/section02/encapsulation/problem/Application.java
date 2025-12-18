package com.ohgiraffers.section02.encapsulation.problem;

public class Application {
    public static void main(String[] args) {

        /* 필드에 직접 접근할 때 발생하는 문제점 */

        Children children = new Children();

        // 문제 1: 데이터의 신뢰성 훼손
        // 나이는 음수일 수 없는데, 직접 접근을 막을 방법이 없다.
        children.name = "김영희";
        children.age = -10;
        System.out.println(children.name +"는 " + children.age + "세 입니다.");

        // 문제 2: 유지보수의 어려움
        // 만약 Children 클래스의 필드명이 변경된다면, 즉시 에러를 발생시킨다.
        // 클래스 내부의 변경이 클래스 바깥까지 영향을 미치는 '높은 의존성' 상태이다.

    }
}
