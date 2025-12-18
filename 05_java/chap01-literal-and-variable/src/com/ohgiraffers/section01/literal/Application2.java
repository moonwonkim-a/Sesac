package com.ohgiraffers.section01.literal;

public class Application2 {
    public static void main(String[] args) {

        /* 값을 직접 연산하여 출력할 수 있다. */

        /* 숫자와 숫자의 연산 */
        // 정수와 정수의 연산
        System.out.println(123 + 456);
        System.out.println(123 - 23);
        System.out.println(123 * 10 );
        System.out.println(123 / 10 );
        System.out.println(123 % 10 );

        // 실수와 실수의 연산
        System.out.println(1.23 + 1.23);
        System.out.println(1.20 * 1.25);

        // 정수와 실수의 연산(항상 실수가 나온다.)
        System.out.println(123 + 0.5);

        /* 문자의 연산 */
        // 문자끼리도 사칙연산에 나머지 연산까지 가능하다
        System.out.println('a' + 'b');

        /* 문자와 정수의 연산 */
        System.out.println('a' + 1);
        // 결론은 문자는 내부적으로 숫자 취급을 한다는 것!(아스키코드와 유니코드)

        /* 문자열의 연산 */
        // 문자열과 문자열의 '+' 연산 결과는 문자열 합치기가 된다.
        // 문자열은 '+' 연산 외에 다른 연산은 사용하지 못한다.
        System.out.println("hello" + "world");
//        System.out.println("hello" * "world");    // 에러 발생

        // 다른 형태의 값들도 문자열로 취급하여 문자열 합치기 결과가 나온다.
        System.out.println("hello" + 123);
        System.out.println("hello" + 'a');

        System.out.println("123" + "456");  // "123456"

        /* 논리값의 연산 */
        // 모든 연산자 사용 불가
//        System.out.println(true + false);
//        System.out.println(true + 1);
//        System.out.println(true + 1.0);
//        System.out.println(true + 'a');

        System.out.println(true + "a");

        // 문자열 합치기
        System.out.println(9 + 8);      // 17
        System.out.println("9" + 9);    // "99"

        // 세 개의 문자열 합치기
        System.out.println(9 + 9 + "9");    // "189"
        System.out.println("9" + 9 + 9);    // "999"
        System.out.println("9" + (9 + 9));    // "918"

    }
}
