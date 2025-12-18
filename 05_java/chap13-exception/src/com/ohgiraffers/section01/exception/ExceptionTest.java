package com.ohgiraffers.section01.exception;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws Exception {

        System.out.println("가지고 계신 돈은" + money + "원 입니다.");

        if(money >= price) {
            System.out.println("상품을 구입하기 위한 돈이 충분하다.");
        } else {
            throw new Exception("돈이 부족합니다!!");  // 에러 메시지를 담아서 던질 수도 있다.
        }
        System.out.println("즐거운 쇼핑 하세요~");
    }
}
