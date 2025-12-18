package com.ohgiraffers.section02.demensinal;

public class Application1 {
    public static void main(String[] args) {
        /*
        * [ 다차원 배열 ]
        * 2차원 이상의 배열을 의미하며, 배열의 인덱스마다 또 다른 배열의 주소를 보관하는 배열이다.
        * 즉, 2차원 배열은 1차원 배열 여러 개를 하나로 묶어서 관리하는 배열이다.
        * 더 많은 차원의 배열을 사용할 수 있지만 일반적으로 2차원 배열 이상의 배열은 사용 빈도가 현저히 적다.
        *
        * [ 2차원 배열을 사용하는 방법 ]
        * 1. 배열의 주소를 보관할 레퍼런스 변수 선언 (stack)
        * 2. 여러 개의 1차원 배열의 주소를 관리할 배열 생성 (heap)
        * 3. 2에서 생성한 배열의 각 인덱스에서 관리하는 배열을 할당(heap)하여
        *   주소를 보관하는 배열(= 2에서 생성한 배열)에 저장
        * 4. 생성한 여러 개의 1차원 배열에 접근하여 사용
        * */

        // 1. 2차원 배열 선언 및 할당
        int[][] iarr = new int[3][5];

        // 1-1. 2차원배열(정변, 가변) 선언과 동시에 할당 및 초기화
        // 바깥쪽 {}는 배열 전체, 안쪽 {}는 각 행(층)을 의미.
        int[][] iarr2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {11, 12, 13}};

        // 2. 중첩 반복문을 이용한 값 대입
        int value = 1;
        // '층'을 순회(0층, 1층, 2층)
        for(int i = 0; i < iarr.length; i++) {
            for(int j = 0; j < iarr[i].length; j++){
                iarr[i][j] = value++;
            }
        }

        for(int i = 0; i < iarr.length; i++) {
            for(int j = 0; j < iarr[i].length; j++) {
                System.out.print(iarr[i][j] + " ");
            }
        System.out.println();
        }
    }
}
