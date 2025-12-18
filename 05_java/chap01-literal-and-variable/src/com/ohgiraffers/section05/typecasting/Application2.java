package com.ohgiraffers.section05.typecasting;

public class Application2 {
    public static void main(String[] args) {

        /* 강제형변환
        * 바꾸려는 자료형으로 캐스트 연산자를 이용하여 형변환한다.
        * (바꿀자료형) 값;
        * */

        /**
         * 큰 자료형에서 작은 자료형으로 변경 시 강제 형변환이 필요하다.
         */
        long lnum = 8;
//        int inum = lnum;    // 데이터 손실 가능성을 컴파일러가 알려준다. (에러남)
        int inum = (int)lnum;   // 변경하려는 자료형을 명시하여 강제 형변환을 해아 한다.

        short snum = (short)inum;

        /**
         * 실수를 정수로 변경 시 강제 형변환이 필요하다.
         * */
        float fnum2 = 4.0f;
        long lnum2 = (long)fnum2;   // 데이터 손실을 감안할테니 형변환 해줘
    }
}
