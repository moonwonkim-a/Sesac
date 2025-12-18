package com.ohgiraffers.section01.operator;

public class Application {
    public static void main(String[] args) {
        /*
        * 산술 연산자(+, -, *, /, %)
        * 피연산자들의 연산 방향은 왼쪽에서 오른쪽이다.
        *
        * '%' : 왼쪽의 피연산자를 오른쪽의 피연산자로 나눈 나머지를 반환
        * */

        /* 산술 복합 대입 연산자(+=, -=, *=, /=, %=)
        * 왼쪽의 피연산자에 오른쪽의 피연산자를 산술 한 결과를 왼쪽의 피연산자에 대입함
        * */

        int num = 12;

        num += 3;   // num = num + 3;

        /* 증감 연산자 (++, --)
        * '++' : 1 증가의 의미
        * '--' : 1 감소의 의미
        * */

        num++;  // 다른 연산을 먼저 진행하고 마지막에 피연산자의 값을 1 증가시킴
        ++num;  // 피연산자의 값을 먼저 1 증가시킨 후 다른 연산을 진행함
        num--;
        --num;

        int firstNum = 20;

        int result1 = ++firstNum * 3;

        System.out.println("result1 = " + result1);
        System.out.println("firstNum = " + firstNum);

        /*
        * 비교연산자(==, !=, >, <, >=, <=)
        * 피연산자 사이에서 상대적인 크기를 판단하여 참 혹은 거짓을 반환하는 연산자.
        * */

        int num1 = 10;
        int num2 = 20;

        System.out.println(num1 == num2);   // false
        System.out.println(num1 != num2);   // true
        System.out.println(num1 < num2);    // true
        System.out.println(num1 > num2);    // false
        System.out.println(num1 <= num2);   // true
        System.out.println(num1 >= num2);   // false

        /* 문자값 비교 */
        char ch1 = 'a';     // 97
        char ch2 = 'A';     // 65

        System.out.println(ch1 == ch2);
        System.out.println(ch1 != ch2);
        System.out.println(ch1 >= ch2);

        /* 문자열, 논리값 비교 */
        /* ==과 !=은 비교 가능하지만 대소비교는 불가능 */
        String str1 = "java";
        String str2 = "java";

        System.out.println(str1 == str2);
//        System.out.println(str1 >= str2);

        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(bool1 == bool2);


    }
}
