package com.ohgiraffers.section06.singleton;

public class Application {
    public static void main(String[] args) {

        /*
        * 디자인 패턴이란?
        * 자주 등장하는 문제를 효과적으로 해결하기 위한 재사용 가능한 설계 방법
        * 프로그래밍에서 자주 부딪히는 문제를, 이미 검정된 구조로 미리 약속해둔 설계 템플릿
        *
        * [ 싱글톤(singleton)패턴 ]
        * - 프로그램 전체에서 단 하나의 객체만 존재하도록 보장하는 패턴
        * - 객체를 단 한번만 만들고, 모두가 그 인스턴스를 공유하도록 하는 것
        *   (ex.설정 정보 관리 객체, 데이터베이스 연결 정보 등)
        *
        * [ 핵심 규칙 ]
        * 1. 외부에서 마음대로 객체를 생성하지 못하게 막는다. (생성자를 private으로 설정)
        * 2. 클래스 자기 자신이 유일한 객체를 '직접' 생성하고 보관한다. (private static)
        * 3. 이 유일한 객체를 외부에 전달해줄 '창구'를 만든다.(public static 메소드)
        * */

        /* 이른 초기화
        * 생성자를 이용해 인스턴스 생성을 하지 못하고, getInstance() 메소드를 호출해야만 인스턴스를 생성할 수 있다.*/
//        EagerSingleton eager1 = new EagerSingleton(); // 생성자가 private라 접근 불가

        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();

        System.out.println(eager1.hashCode());
        System.out.println(eager2.hashCode());
        System.out.println(eager1 == eager2);

        /* 게으른 초기화 */
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();

        System.out.println(lazy1.hashCode());
        System.out.println(lazy2.hashCode());
        System.out.println(lazy1 == lazy2);
    }
}
