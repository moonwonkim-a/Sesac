package com.ohgiraffers.section03.dto;

public class Application {
    public static void main(String[] args) {

        // 비어있는 데이터 상자를 하나 생성한다.
        MemberDTO member = new MemberDTO();

        // setter를 이용하여 데이터를 담는다.
        member.setNumber(1);
        member.setName("홍길동");
        member.setAge(20);
        member.setGender('남');
        member.setHeight(180.5);
        member.setWeight(80.6);
        member.setActivated(true);

        // Getter를 이용해 데이터를 확인한다.
        System.out.println(member.getAge());
        System.out.println(member.getName());
        System.out.println(member.getGender());
        System.out.println(member.isActivated());
        System.out.println(member.getHeight());
        System.out.println(member.getWeight());
        System.out.println(member.getNumber());
    }
}
