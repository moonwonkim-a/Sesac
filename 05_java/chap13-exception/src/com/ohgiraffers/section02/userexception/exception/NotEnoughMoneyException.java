package com.ohgiraffers.section02.userexception.exception;

public class NotEnoughMoneyException extends Exception{

    /* 사용자 정의 예외 클래스를 만들기 위해서는 Exception클래스를 상속 받으면 된다. */

    // 기본생성자
    public NotEnoughMoneyException() {}

    // 예외 발생 시 전달할 메시지를 부모(Exception)에 넘겨주는 생성자
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
