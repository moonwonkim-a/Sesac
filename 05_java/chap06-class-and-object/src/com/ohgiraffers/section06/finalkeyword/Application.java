package com.ohgiraffers.section06.finalkeyword;

public class Application {
    public static void main(String[] args) {

        /*
        * final 키워드
        * 1. 변수(지역/필드)에 사용: 값 변경 불가 -> '상수'가 된다.
        * 2. 메소드에 사용: 재정의(Override) 불가
        * 3. 클래스에 사용: 상속 불가
        * */

        System.out.println("원주율 : " + MathConstant.PI);
//        MathConstant.PI = 3.14;   // final 변수는 다시 값을 할당할 수 없ㄷㅏ.

        Person person = new Person("000000-1111111", "홍길동");
        person.setName("홍길동 주니어");
//        person.ssn = "010101 - 2222222";  // final 필드는 외부에서도 변경 불가능

        // 부모의 'final' 메소드를 사용하는 것은 가능하다. 하지만 오버라이딩은 불가능하다.
        Child child = new Child();
        child.coreMethod();
    }
}
