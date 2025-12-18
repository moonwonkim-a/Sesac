package com.ohgiraffers.section06.singleton;

public class EagerSingleton {

    /* 클래스가 초기화 되는 시점에 인스턴스를 생성한다. */
    private static EagerSingleton eager = new EagerSingleton();

    /* 싱글톤 패턴은 생성자 호출을 통해 외부에서 인스턴스 생성하는 것을 제한 */
    private EagerSingleton() {}

    /* public 인터페이스로 인스턴스를 반환하도록 한다. */
    public static EagerSingleton getInstance() {
        return eager;
    }

}
