package com.ohgiraffers.section05.overloading;

public class OverloadingRules {

    /* 메소드 시그니처를 기준으로 오버로딩의 성립 조건을 이해할 수 있다.
    *
    * [ 메소드 시그니처 ]
    * 메소드를 식별하기 위한 고유한 이름표
    * '메소드 이름' + '매개변수 리스트(타입, 개수, 순서)'
    * ex) test(int num, String name)
    *
    * 오버로딩 : 이름은 같지만, 시그니처가 다른 메소드를 여러 개 정의하는 기술
    * */

    public void test() {}

    // 1. 매개변수 '개수'가 다르면 오버로딩 성립
    public void test(int num) {}

    // 2. 매개변수 '타입'이 다르면 오버로딩 성립
    public void test(String str) {}

    // 3. 매개변수 '타입' 순서가 다르면 오버로딩 성립
    public void test(int num, String str) {}
    public void test(String str, int num) {}


    /* [ 오버로딩이 성립하지 않는 경우 ] */
    // 접근 제한자, 반환 타입, 매개변수 이름은 시그니처에 포함되지 않기때문에 오버로딩이 성립되지 않는다.

    // 1. 반환 타입만 다른 경우 (시그니처가 test()로 동일함)
//    public int test() {};

    // 2. 접근 제한자만 다른 경우 (시그니처가 test()로 동일함)
//    private void test() {}

    // 3. 매개변수의 '이름'만 다른 경우 (시그니처가 test(int)로 동일함)
//    public void test(int num2) {}


}
