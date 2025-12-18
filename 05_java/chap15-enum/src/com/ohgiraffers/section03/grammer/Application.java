package com.ohgiraffers.section03.grammer;

import java.util.EnumSet;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {

        /* UserRole 타입의 변수를 만들기만 해도, 클래스가 로드되면서 UserRole의 모든 상수가 인스턴스화 된다.(생성자 호출) */
        UserRole admin = UserRole.ADMIN;

        // 인스턴스가 위에서 이미 생성되었기 때문에 생성자가 다시 호출되지 않는다 -> 싱글톤
        UserRole guest = UserRole.GUEST;

        System.out.println("역할 : " + admin.name());
        System.out.println("설명 : " + admin.getDescription());
        System.out.println("영문 소문자 : " + admin.getNameToLowerCase());

        // 싱글톤이기 때문에 이미 생성된 인스턴스를 재사용한다. '==' 비교에서 true가 나온다!!
        UserRole admin2 = UserRole.ADMIN;
        System.out.println("admin == admin2 : " + (admin == admin2));

        //  enum만을 위한 빠르고 효율적인, EnumSet
        // 1. allOf() : 모든 상수 가져오기
        EnumSet<UserRole> allRoles = EnumSet.allOf(UserRole.class);
        printEnumSet(allRoles);

        // 2. of() : 특정 상수만 골라 담기
        // 권한 관리에 유용
        EnumSet<UserRole> userRoles = EnumSet.of(UserRole.CONSUMER, UserRole.PRODUCER);
        printEnumSet(userRoles);

        // 3. complementOf() : 특정 상수만 '제외'하고 담기 (여집합)
        EnumSet<UserRole> memberRoles = EnumSet.complementOf(EnumSet.of(UserRole.GUEST));
        printEnumSet(memberRoles);


    }
    // EnumSet의 내용을 보기 좋게 출력하기 위한 헬퍼 메소드
    public static void printEnumSet(EnumSet<UserRole> enumSet) {
        Iterator<UserRole> iter = enumSet.iterator();
        while(iter.hasNext()) {
            UserRole role = iter.next();
            System.out.println(role.name() + "(" + role.getDescription() + ", " + role.getCode() + ")");
        }
        System.out.println();
    }
}
