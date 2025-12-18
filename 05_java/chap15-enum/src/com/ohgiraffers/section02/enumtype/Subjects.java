package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    // 작성한 순서대로 0부터 값이 자동 부여된다.
    JAVA("자바"),
    MYSQL("데이터언어"),
    JDBC("몰렁"),
    HTML("프론트"),
    CSS("꾸미기"),
    JAVASCRIPT("꾸미기언어");


    private final String name;

    private Subjects (String name){
        this.name = name;
    }
}


