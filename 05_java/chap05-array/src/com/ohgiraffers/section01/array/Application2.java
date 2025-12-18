package com.ohgiraffers.section01.array;

public class Application2 {
    public static void main(String[] args) {

        /*
        * [배열 사용 방법]
        * 1. 배열의 선언 : "이런 배열을 만들겠습니다" 라고 약속하는 단계
        * 2. 배열의 할당 : "실제 몇 칸짜리 배열을 만들겠습니다" 라고 생성하는 단계
        * 3. 배열의 사용 : 각 칸(인덱스)에 값을 넣거나 꺼내서 사용
        * */

        // 1. 배열 선언
        // stack 영역에 배열의 주소를 보관할 수 있는 공간(레퍼런스 변수)을 만드는 것
        int[] iarr; // 더 권장되는 방식
        char carr[];

        // 2. 배열 할당
        // new 연산자는 heap영역에 실제 데이터 공간을 할당하고, 그 주소값을 반환한다.
        iarr = new int[5];

        // 선언과 동시에 할당
        int[] iarr2 = new int[5]; // 다섯칸의 배열을 만들고 기본값으로 초기화

        // 블럭{}을 사용하는 경우 값의 갯수만큼 자동으로 크기가 설정된다.
        int[] iarr3 = new int[]{11, 22, 33, 44, 55};

        // new 연산자 생략
        int[] iarr4 = {11, 22, 33, 44, 55}; // 선언과 동시에 할당하는 경우만 가능


        /* 값을 넣지 않으면 기본값으로 채워준다(초기화)
        * 정수는 '0', 실수는'0.0', 논리형은 'false' 문자형은 (\u0000) 참조형은 null */

        for(int i = 0; i < iarr.length; i++) {
            System.out.println(i + "번 인덱스의 값 : " + iarr[i]);
        }

        iarr[0] = 10;
        iarr[1] = 20;
        iarr[2] = 30;
        iarr[3] = 40;
        iarr[4] = 50;
//        iarr[5] = 60; // 5번 인덱스는 존재하지 않기 때문에 에러 발생 ArrayIndexOutOfBoundsException

        for(int i = 0; i < iarr.length; i++) {
            System.out.println(i + "번 인덱스의 값 : " + iarr[i]);
        }

        // 문자열도 배열로 사용할 수 있다.
        String[] sarr = {"apple", "banana", "orange"};

        for(int i = 0; i < sarr.length; i++ ) {
            System.out.println("sarr[" + i + "]의 값: " + sarr[i]);
        }
    }
}
