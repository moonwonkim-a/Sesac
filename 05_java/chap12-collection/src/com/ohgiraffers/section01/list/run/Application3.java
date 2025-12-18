package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {

        /* [ LinkedList ]
        * ArrayList가 배열을 이용하는 것과 달리, '이중 연결 리스트' 방식으로 데이터를 관리한다.
        * 각 요소는 자신의 앞/뒤 요소만 기억한다.
        *
        * 장점 : 중간에 데이터를 추가하거나 삭제할 때, 앞뒤 연결만 바꿔주면 되므로 매우 빠르다.
        * 단점 : 특정 위치(인덱스)의 데이터를 찾으려면, 처음부터 순서대로 찾아가야 하므로 조회 속도가 느리다.
        *
        * 데이터의 추가/삭제가 매우 빈번하게 일어나는 경우 ArrayList보다 유리하다.
        * */

        List<String> linkedList = new LinkedList<>();

        linkedList.add("apple");
        linkedList.add("grape");
        linkedList.add("banana");

        System.out.println(linkedList);

        // 요소 조회 (ArrayList보다 내부적으로 느림)
        System.out.println(linkedList.get(0));

        // 요소 삭제
        linkedList.remove(1);
        System.out.println("삭제 후 :" + linkedList);

        // 요소 수정
        linkedList.set(0, "pineapple");
        System.out.println("수정 후 : " + linkedList);

        // 리스트 비우기
        linkedList.clear();
        System.out.println(linkedList.isEmpty());
    }
}
