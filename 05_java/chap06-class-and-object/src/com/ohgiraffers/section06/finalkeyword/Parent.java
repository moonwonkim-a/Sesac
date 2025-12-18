package com.ohgiraffers.section06.finalkeyword;

public class Parent {

    /* final 메서드
    * 이 메소드는 자식 클래스에서 재정의(Override)할 수 없다.
    * */

    public final void coreMethod() {
        System.out.println("이것은 부모의 중요한 핵심 로직입니다. 절대 바꾸지 마세요~");
    }
}
