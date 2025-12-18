package com.ohgiraffers.section02.set;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        /*
        * TreeSet
        * - '중복 불가'의 특징과 함께, 요소를 저장할 때마다 자동으로 오름차순 정렬을 해준다.
        *
        * 자동 정렬의 비밀
        * - TreeSet에 추가되는 요소는 반드시 'Comparable' 인터페이스를 구현하고 있어야 한다.
        * - String, Integer 등의 기본자료형 Wrapper 클래스들은 이미 'Comparable' 이 구현되어있어 자동 정렬된다.
        * */

        TreeSet<String> tset = new TreeSet<>();
        tset.add("java");
        tset.add("html");
        tset.add("mysql");
        tset.add("css");
        tset.add("java");   // 중복은 여전히 불가

        System.out.println(tset);

        Set<BookDTO> bookSet = new TreeSet<>();
        bookSet.add(new BookDTO(2, "목민심서", "정약용", 30000));
        bookSet.add(new BookDTO(1, "홍길동전", "허균", 50000));
        bookSet.add(new BookDTO(3, "동의보감", "허준", 40000));

        System.out.println("BookDTO TreeSet 결과 : ");
        for (BookDTO book : bookSet) {
            System.out.println(book);
        }

        // TreeSet 특징을 활용한 로또 번호 생성기
        Set<Integer> lotto = new TreeSet<>();

        while(lotto.size() < 6) {
            lotto.add((int)((Math.random() * 45)) + 1);
        }

        System.out.println(lotto);

    }
}
