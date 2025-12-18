package com.ohgiraffers.section02.uses;

import java.util.Scanner;

public class MemberService {

    public void signUpMembers() {

        Member[] members = new Member[5];
        members[0] = new Member(1, "user01", "pass01", "홍길동", 20, '남');
        members[1] = new Member(2, "user02", "pass02", "유관순", 16, '여');
        members[2] = new Member(3, "user03", "pass03", "이순신", 40, '남');
        members[3] = new Member(4, "user04", "pass04", "신사임당", 36, '여');
        members[4] = new Member(5, "user05", "pass05", "윤봉길", 22, '남');

        // MemberRepository.store() 메소드에 'Member 객체 배열'을 매개변수로 전달
        if(MemberRepository.store(members)) {
            System.out.println("총 " + members.length + "명의 회원 등록을 성공했다.");
        } else {
            System.out.println("정원이 초과되어 등록에 실패했다.");
        }
    }

    /* 전체 회원 조회를 담당하는 메소드
    * MemberRepository로부터 회원 정보를 받아와서 출력한다. */
    public void showAllMembers() {
        // MemberRepository.findAllMembers() 메소드로부터 'Member 객체 배열'을 리턴받음
        Member[] allMembers = MemberRepository.findAllMembers();

        for(Member member : allMembers) {
            if(member != null) {
                System.out.println(member.getInformation());
            }
        }
    }

    public void searchMemberById(Scanner sc) {

        // 1. 사용자에게 검색할 아이디를 입력받는다.
//        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 회원의 아이디를 입력하세요 : ");
        String searchId = sc.nextLine();

        // 2. MemberRepository에서 모든 회원 정보를 가져온다. (객체 배열을 리턴받음)
        Member[] foundMembers = MemberRepository.findAllMembers();

        // 3. 검색 결과를 찾았는지 여부를 확인하기 위한 boolean 변수(Flag) 선언
        boolean isFound = false;

        // 4. 반복문을 이용해 전체 회원 배열을 탐색한다.
        for(Member member : foundMembers) {
            // 배열의 각 칸이 null이 아닌지 먼저 확인
            if (member != null) {
                // 회원의 아이디가 입력받은 아이디와 일치하는지 확인 (문자열 비교는 .equals() 사용!!)
                // 참고. ==는 두 변수가 같은 객체를 참조하는지(주소값 비교)를 확인
                if (searchId.equals(member.getId())) {
                    // 일치하는 회원 찾았을 경우, 정보 출력
                    System.out.println("-------검색 결과---------");
                    System.out.println(member.getInformation());

                    isFound = true; // 찾았다!
                    break;          // 반복문 종료
                }
            }
        }
        // 반복문이 끝날 때까지 회원을 찾지 못했다면(isFound가 여전히 false라면!!)
        if(!isFound) {
            System.out.println("해당 아이디" + searchId + " 회원을 찾을 수 없습니다.");
        }


    }

}
