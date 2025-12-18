package com.ohgiraffers.section03.copy;


import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {

        /*
        * [깊은 복사]
        * heap에 새로운 배열을 생성하고, 기존 배열의 값을 그대로 복사한다.
        * 따라서 두 배열은 서로 독립적이므로, 한쪽을 수정해도 다른 쪽에 영향이 없다.
        * */

        int[] originArr = {1, 2, 3, 4, 5};
        System.out.println("originArr : " + originArr.hashCode());
        System.out.println("-----------------------------");

        /*[ 깊은 복사를 하는 방법 4가지 ]*/

        // 1.for문을 이용한 수동 복사
        int[] copyFor = new int[originArr.length];
        for (int i = 0; i < originArr.length; i++) {
            copyFor[i] = originArr[i];
        }
        print("copyFor", copyFor);

        // 2. Arrays.copyOf() 이용 (가장 추천!)
        // Arrays.copyOf(원본배열, 복사할 길이);
        int[] copyOf = Arrays.copyOf(originArr, originArr.length);
        print("copyOf", copyOf);

        // 3. System.arraycopy() (고성능, 복잡함)
        int[] arrayCopy = new int[originArr.length];
        // System.arraycopy(원본, 원본시작위치, 사본, 사본시작위치, 복사할길이);
        System.arraycopy(originArr, 0, arrayCopy, 0, originArr.length);
        print("arrayCopy", arrayCopy);

        // 4. clone() (간단하지만, 크기 조절 불가)
        int[] copyClone = originArr.clone();
        print("copyClone", copyClone);

        copyClone[0] = 99;

        print("orginArr", originArr);
        print("copyClone", copyClone);
    }

    public static void print(String name, int[] arr) {
        System.out.println(name + " hashCode: " + arr.hashCode() + ", array: " + Arrays.toString(arr));
    }


}
