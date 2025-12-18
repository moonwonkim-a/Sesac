package com.ohgiraffers.section06.statickeyword;

public class CampusActivity {

    // non-static : 개인 사물함
    private int personalLockerCount;

    // non-static 메소드
    public void openPersonalLocker() {
        this.personalLockerCount++;
        System.out.println("개인 사물함을 열었습니다. 사용 횟수: " + this.personalLockerCount);
    }

    // static 메소드
    public static void libraryAnnouncement() {
//        this.personalLockerCount++;
        System.out.println("도서관 공지 방송입니다.");
    }
}
