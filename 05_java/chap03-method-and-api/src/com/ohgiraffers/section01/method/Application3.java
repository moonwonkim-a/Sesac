package com.ohgiraffers.section01.method;

public class Application3 {
    public static void main(String[] args) {

        /*
        * static 메소드 호출 방법
        * 클래스명.메소드명();
        * */
        System.out.println("10과 20의 합: " + Application3.sumTwoNumbers(10, 20));

        /* 동일한 클래스 내에 작성된 static 메소드는 클래스명 생략이 가능 */
        System.out.println("20과 30의 합: " + sumTwoNumbers(20, 30));
    }

    public static int sumTwoNumbers(int first, int second) {
        return first + second;
    }
}
