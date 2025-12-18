package com.ohgiraffers.section03.copy;

public class Application1 {
    public static void main(String[] args) {

        /*
        * [ 얕은 복사 ]
        * stack의 주소 값만 복사하므로, 두 변수가 동일한 배열(heap)을 참조한다.
        * 따라서 한쪽에서 배열을 수정하면 다른 쪽에도 영향이 간다.
        * */

        // 원본 배열 생성
        int[] originArr = {1, 2, 3, 4, 5};

        // 얕은 복사
        int[] copyArr = originArr;

        // hashCode()를 통해 두 변수가 같은 주소를 가리키는지 확인
        System.out.println(originArr.hashCode());
        System.out.println(copyArr.hashCode());

        System.out.println(originArr[4]);
        copyArr[4] = 90;
        System.out.println(originArr[4]);

        /*
        * [ 얕은 복사의 활용 ]
        * 메소드에 인자로 배열을 전달하거나, 메소드가 배열을 반환할 때 발생
        * 이는 메모리를 효율적으로 사용하기 위한 자바의 기본 동작 방식이다.
        * */
    }
}
