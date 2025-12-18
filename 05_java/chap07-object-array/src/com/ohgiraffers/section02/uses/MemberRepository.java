package com.ohgiraffers.section02.uses;

public class MemberRepository {

    /* 회원 정보를 저장할 배열을 static으로 선언
    * 이 클래스의 객체를 만들지 않아도 MemberRepository.members 로 바로 접근해서 사용할 수 있다.
    * 프로그램이 시작될 때 메모리에 딱 한 번만 생성되어 모든 곳에서 공유된다. */
    private final static Member[] members;

    private static int count;

    // static 필드를 초기화 하기 위해 사용
    // 프로그램이 시작될 때 단 한 번 실행된다.
    static {
        members = new Member[10];
    }

    /* 매개변수로 전달 받은 Member 객체 배열을 Repository의 members 배열에 저장하는 메소드 */
    public static boolean store(Member[] newMembers) {

        for(int i = 0; i < newMembers.length; i++) {
            members[count++] = newMembers[i];
        }
        return true;
    }

    /* 저장된 members 배열을 그대로 반환해주는 메소드 */
    public static Member[] findAllMembers() {
        return members;
    }
}
