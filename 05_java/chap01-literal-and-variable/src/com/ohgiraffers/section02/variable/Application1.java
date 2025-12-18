package com.ohgiraffers.section02.variable;

public class Application1 {
    public static void main(String[] args) {

        /* 변수를 사용하는 방법
        * 1. 변수를 준비한다.(선언)
        * 2. 변수에 값을 대입한다.(값 대입 및 초기화)
        * 3. 변수를 사용한다.
        * */

        /* 변수 선언
        *  자료형 변수명;
        * */

        /* 자료형이란?
        * 다양한 값의 형태별로 어느 정도 크기를 하나의 값으로 취급할 것인지 미리 Compiler와 약속한 키워드이다.
        * 기본자료형은 8가지가 있다.*/

        /* 정수를 취급하는 자료형 */
        byte bnum;      //1byte
        short snum;     //2byte
        int inum;       //4byte
        long lnum;      //8byte

        /* 실수를 취급하는 자료형 */
        float fnum;     //4byte
        double dnum;    //8byte

        /* 문자를 취급하는 자료형 */
        char ch;    //2byte

        /* 논리값을 취급하는 자료형 */
        boolean isTrue;     //1byte

        /* 이상 8가지를 기본자료형(Primary type)이라고 한다. */

        // 문자열은 조금 다른 방식으로 취급한다(기본자료형X)
        String str; //4byte

        /* 변수를 선언하고 난 뒤 최초로 값이 대입되는 것을 초기화 라고 한다.
        * 선언과 값 대입을 동시에 수행할 수도 있다.
        * */
        int point = 100;    // 선언과 동시에 초기화
        int bonus = 10;

        System.out.println("포인트와 보너스의 합은? : " + (point + bonus));
    }
}
