package com.ohgiraffers.section01.user_type;

public class Member {

    /*
    * [클래스]
    *  비유: '회원'이라는 객체를 만들기 위한 '설계도'
    *
    * '회원'이 어떤 데이터(속성)와 어떤 기능(메소드)을 가져야 하는지 정의한다.
    * 이 파일 자체는 실제 회원이 아니며, 실제 회원을 만들기 위한 정의서일 뿐이다.
    * */
    /*
    * [필드 == 속성 == 인스턴스(객체) 변수]
    *
    * 클래스가 가질 데이터 종류를 변수 형태로 선언
    * '회원'이라는 객체는 아래와 같은 속성(데이터)들을 가진다.
    * */
    String id;
    String pwd;
    String name;
    int age;
    char gender;
    String[] hobby;

}
