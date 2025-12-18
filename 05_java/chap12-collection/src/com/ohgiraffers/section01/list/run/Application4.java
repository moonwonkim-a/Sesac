package com.ohgiraffers.section01.list.run;

import java.util.EmptyStackException;
import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {

        /* Stack
        * - 후입선출(LIFO) 방식의 자료구조이다.
        *
        * - 웹 브라우저의 '뒤로 가기' 기능
        * - 프로그램의 '실행 취소' 기능
        * - 재귀 알고리즘을 반복문으로 구현할 때
        * */

        Stack<Integer> integerStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        strStack.push("그림");
        strStack.push("사진");
        strStack.push("점자");
        strStack.push("포토샾");
        System.out.println(strStack);
        System.out.println(strStack.peek());
        System.out.println(strStack.pop());
        System.out.println(strStack);
        System.out.println(strStack.get(0));
        // stack에 값을 넣을때는 push() 사용
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);

        System.out.println(integerStack);

        /*
        * peek() : 가장 꼭대기 요소를 '확인만'하고 제거하지는 않는다.
        * pop() : 가장 꼭대기 요소를 '꺼내고' 제거한다.
        * */

        System.out.println("peek() : " + integerStack.peek());
        System.out.println(integerStack);

        System.out.println("pop() : " + integerStack.pop());
        System.out.println(integerStack);

        try{
            integerStack.pop();
            integerStack.pop();
            integerStack.pop(); // 이미 여기에서 stack이 다 비워짐
            integerStack.pop(); // 에러 발생!!
        } catch (EmptyStackException e){
            System.out.println("스택이 비어있습니다.");
        }
    }
}
