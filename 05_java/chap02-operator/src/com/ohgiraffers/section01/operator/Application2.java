package com.ohgiraffers.section01.operator;

public class Application2 {
    public static void main(String[] args) {

        /* 논리 연산자
        * 논리값(true or false)를 취급하는 연산자이다.
        *
        * 1. 논리 연결 연산자
        * - &&(논리 AND) 연산자: 두 개의 논리식 모두 참 일 경우 참, 한개라도 거짓인경우 거짓 반환
        * - ||(논리 OR) 연산자: 두 개의 논리식 중 하나라도 참 일 경우 참, 둘 다 거짓인경우 거짓 반환
        *
        * 2. 논리 부정 연산자
        * - !(논리 NOT) 연산자: 논리식의 결과가 참이면 거짓을, 거짓이면 참을 반환
        * */

        System.out.println(true && true);   // true
        System.out.println(true && false);  // false
        System.out.println(true || false);  // true
        System.out.println(!true);          // false

        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;

        System.out.println(a < b && c < d);     // true
        System.out.println(a < b || c > d);     // true

        /* 1부터 100 사이의 값인지 확인 */
        // 1 <= 변수 <= 100 이렇게 사용 못함 --> 변수 >= 1 && 변수 <= 100
        int num1 = 55;
        System.out.println("1부터 100 사이인지 확인: " + (num1 >= 1 && num1 <= 100));

        /* 영어 대문자인지 확인 */
        char ch1 = 'g';
        System.out.println("영어 대문자인지 확인: " +  (ch1 >= 'A' && ch1 <= 'Z'));

        /*
        * AND 연산과 OR 연산의 특징
        * 논리식 && 논리식 : 앞의 결과가 false이면 뒤를 실행 안함
        * 논리식 || 논리식 : 앞의 결과가 true이면 뒤를 실행 안함
        * */

        int num2 = 10;

        int result1 = (false && ++num2 > 0)? num2 : num2;
        System.out.println("result1 = " + result1);
        
        int num3 = 10;
        
        int result2 = (true || ++num3 > 0)? num3 : num3;
        
        /* 삼항연산자 
        * 피연산자 항목이 3개인 연산자이다.
        * (조건식)? 참일 때 사용할 값1 : 거짓일 때 사용할 값2
        * */
        
        int num4 = 10;
        int num5 = -20;
        String result3 = (num4 > 0)? "양수다." : "양수가 아니다.";
        String result4 = (num5 > 0)? "양수다." : "양수가 아니다.";

        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);

        String result5 = (num4 < 0)? "음수다." : (num4 == 0)? "0이다" : "양수다.";
        System.out.println("result5 = " + result5);


    }
}
