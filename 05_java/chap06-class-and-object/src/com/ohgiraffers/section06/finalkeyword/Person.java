package com.ohgiraffers.section06.finalkeyword;

public class Person {

    /*
    * [ final 인스턴스 변수 ]
    * 객체가 생성될 때 결정된 후, 다시는 변경할 수 없는 필드.
    * */

    final String ssn;   // 주민등록번호
    private String name;

    // final 필드는 반드시 '생성자'에서 초기화 되어야 한다.
    public Person(String ssn, String name) {
        this.ssn = ssn;
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
