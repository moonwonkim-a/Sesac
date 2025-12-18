package com.ohgiraffers.section01.exception;

public class Application {

    public static void main(String[] args) throws Exception {

        ExceptionTest et = new ExceptionTest();

        System.out.println("정상 케이스");
        et.checkEnoughMoney(10000, 50000);

        System.out.println("예외 발생 케이스");
        et.checkEnoughMoney(10000, 3000);

        System.out.println("프로그램을 종료합니다.");
    }
}
