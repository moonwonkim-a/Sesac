package com.ohgiraffers.section01.list.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        /* 컬렉션 프레임워크란?
        * - 여러 개의 데이터(객체)를 효과적으로 관리하기 위해 자바에서 제공하는 클래스들의 묶음
        * - 크게 List, Set, Map 인터페이스로 분류된다.
        * */

        /*
        * ArrayList
        * - List 인터페이스의 가장 대표적인 구현 클래스
        * - 데이터에 순서(인덱스)가 있고, 중복된 데이터 저장을 허용한다.
        * - 내부적으로는 '배열'을 사용하여 데이터를 관리한다.
        * */

//        ArrayList alist = new ArrayList();    // 사용은 가능하지만, 권장되지 않는다.

        List alist = new ArrayList();
        alist.add("apple");
        alist.add(123);
        alist.add(45.67);
        alist.add(false);

        System.out.println("제네릭 없는 alist = " + alist);

        // 제네릭을 지정하지 않으면 리스트에 저장된 요소들이 Object 타입으로 취급된다.
        // 따라서 값을 꺼내서 원래 타입으로 사용하려면, 매번 형변환을 해야 한다.
        String fruit = (String) alist.get(0);

        /* 제네릭 사용 */
        List<String> stringList = new ArrayList<>();
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("mango");
//        stringList.add(123);  // 컴파일 에러!
        stringList.add("mango");

        System.out.println(stringList);

        /*  리스트 정렬하기 */
        /* Collections 클래스는 컬렉션을 다루는데 유용한 static 메소드들을 제공하는 유틸리티 클래스이다.
        * ( Collection 인터페이스와 다름!!) */

        // 오름차순 정렬
        Collections.sort(stringList);

        System.out.println("오름차순 정렬 후 : " + stringList);

        // 내림차순 정렬
        // List 인터페이스에서 제공하는 sort 메소드에 Comparator.reversOrder()를 인자로 전달
        stringList.sort(Comparator.reverseOrder());
        System.out.println("내림차순 정렬 후 : " + stringList);

    }
}
