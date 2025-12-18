package com.ohgiraffers.section06.finalkeyword;

final class SealedClass {

    /*
    * final 클래스
    * 이 클래스는 다른 어떤 클래스도 상속할 수 없다.
    * 누구도 이 클래스를 부모 삼아 자식 클래스를 만들 수 없다.
    * */
    public void showInfo() {
        System.out.println("저는 final 클래스라 상속이 불가능합니다");
    }
}
