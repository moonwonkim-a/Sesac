package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application4 {
    public static void main(String[] args) {

        int[] arr = {2, 7, 3, 5, 1, 9};

        // Arrays.sort() : 자바 개발자들이 만들어 놓은 매우 효율적인 정렬 기능

        // 오름차순 정렬 끝
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
