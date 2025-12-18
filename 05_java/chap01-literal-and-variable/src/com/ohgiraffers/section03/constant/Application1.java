package com.ohgiraffers.section03.constant;

public class Application1 {
    public static void main(String[] args) {

        /* 상수란?
        * 변수가 메모리에 변경될 값을 저장하기 위한 공간을 나타낸다면, 상수는 이와 상반되는 개념이다.
        * 변하지 않는 값을(항상 고정된 값을)저장해두기 위한 메모리상의 공간을 상수라고 한다.
        * */

        /* 상수 선언 시 자료형 앞에 final 키워드를 붙인다. */
        final int AGE;

        /* 초기화 */
        AGE = 20;
//        AGE = 30;     // 한번 초기화 한 이후 값을 재 대입 하는것은 불가능하다.

        System.out.println("AGE의 값 : " + AGE);

        int sum = AGE;          // 대입 연산자의 오른 편에는 기술 가능
//        int AGE = AGE + 10;     // 대입 연산자의 왼쪽 편에는 기술 불가능

        /* 상수의 명명 규칙
        * 변수의 명명규칙과 컴파일 에러를 발생시키는 규칙은 동일하다.
        * 암묵적인 규칙
        * 1. 모든 문자는 영문자 대문자 혹은 숫자만 사용한다.
        * 2. 단어와 단어 연결은 언더스코어(_)를 사용한다.*/

        final int AGE2;
        final int age2;         // 에러가 발생하지 않지만 변수와 구분하기 힘들다.

        final int MAX_AGE = 50;
        final int MIN_AGE = 30;     // minAge 처럼 카멜케이스 사용 가능하지만 변수와 구분하기 힘들다.
    }
}
