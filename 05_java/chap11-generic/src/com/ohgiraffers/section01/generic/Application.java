package com.ohgiraffers.section01.generic;

public class Application {
    public static void main(String[] args) {
        NormalBox normalBox = new NormalBox();

        normalBox.setContent("안녕하세요");
        // 실수로 잘못된 값을 넣어도 컴파일 에러가 나지 않는다(Object는 모든걸 받아주니까)
//        normalBox.setContent(123);

        // 값을 꺼낼때는 원래 타입인 String으로 직접 형변환 해야한다.
        String content = (String)normalBox.getContent();

        // 이 박스는 오직 String 타입만 담겠습니다!!
        GenericBox<String> stringBox = new GenericBox<>();

        stringBox.setContent("Hello World!");
//        stringBox.setContent(123);    // 컴파일 에러!!

        String strContent = stringBox.getContent();
        System.out.println(strContent);

        // 제네릭에 들어가는 타입은 반드시 "객체 타입"이어야 한다.
        // 기본형을 쓰고 싶다면 래퍼 클래스를 사용하자!!
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setContent(100);
        int intContent = integerBox.getContent();
        System.out.println(intContent + 1);
    }
}
