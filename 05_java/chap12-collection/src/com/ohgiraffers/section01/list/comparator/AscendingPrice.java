package com.ohgiraffers.section01.list.comparator;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.Comparator;

public class AscendingPrice implements Comparator<BookDTO> {
    /*
    * Comparator 인터페이스를 상속받으면 compare 메소드의 오버라이딩이 강제된다.
    * */
    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        /*
        * compare 메소드의 반환값 규칙은 compareTo와 동일하다.
        * - o1이 o2 보다 앞으로 와야 하면 -> 음수 반환
        * - 순서 상관 없으면 -> 0 반환
        * - o1이 뒤로 가야하면 (자리를 바꿔야 하면) -> 양수 반환
        * */
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }

}
