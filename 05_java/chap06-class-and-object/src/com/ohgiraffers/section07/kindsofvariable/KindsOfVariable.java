package com.ohgiraffers.section07.kindsofvariable;

public class KindsOfVariable {

    /*
    * 클래스 영역에 작성하는 변수를 필드라고 한다.
    *  */

    // non-static field를 인스턴스변수라고 한다.
    private int globalNum;

    // static field를 정적필드(클래스변수) 라고 한다.
    private static int staticNum;

    /* 메소드 영역에서 작성하는 변수를 지역변수라고 한다. */
    public void method(int num) {

        // 지역변수와 매개변수 모두 메소드 호출 시 stack 메모리에 생성된다.
        int localNum;

        System.out.println(num);    // 매개변수는 호출 시 값이 넘어오기 때문에 초기화가 필요 없다.

        // 지역변수는 선언 외에 다시 사용(호출)하기 위해서는 반드시 초기화가 되어야 한다.
//        System.out.println(localNum);

        System.out.println(globalNum);  // 전역 변수는 클래스 전역에서 사용 가능하다.
        System.out.println(staticNum);
    }

    public void method2() {
        System.out.println(globalNum);
        System.out.println(staticNum);
//        System.out.println(localNum);   // 지역변수는 해당 지역(블럭 내)에서만 사용 가능하다.
    }
}
