package com.ohgiraffers.section01.exception;

public class Application2 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();

        System.out.println("정상케이스");
        try {
            // 상품 구매 시도
            et.checkEnoughMoney(10000, 300000);
            // try 블록에서 예외가 발생하지 않으면, catch블럭은 실행되지 않고 건너 뛴다.
            System.out.println("상품 구입 가능!!");

        } catch (Exception e) {
            System.out.println("상품 구입 불가!!");
        }
        System.out.println("예외 발생 케이스");

        try {
            // 던져진 예외(Exception)을 받아서, 여기서 책임지고 처리한다.
            et.checkEnoughMoney(30000, 10000);

            System.out.println("상품 구입 가능!!");

        } catch (Exception e) {
            System.out.println("상품 구입 불가!!");
            System.out.println(e.getMessage());
            e.printStackTrace();    // 예외가 발생한 경로를 추적하여 출력한다.
        }

        System.out.println("프로그램을 정상적으로 종료합니다.");
    }
}
