package com.ohgiraffers.section01.intro;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {

        /* 전통적 방식 */
        Calculator c1 = new CalculatorImpl();
        System.out.println(c1.sumTwoNumber(10, 20));

        /* 익명 클래스를 사용하는 방식 */
        Calculator c2 = new Calculator() {
            @Override
            public int sumTwoNumber(int a, int b) {
                return a + b;
            }
        };
        System.out.println(c2.sumTwoNumber(10,20));

        /*
        * [ 람다식을 활용한 방식 ]
        * 자바가 Carculator 인터페이스에 메소드가 '하나만' 있는것을 알고 있다.
        * 따라서 메소드 이름을 생략하고 , 파라미터와 구현부만 간결하게 작성할 수 있다.
        * (x, y) -> x + y; 이 코드 조각이 곧 Calculator 인터페이스의 구현체가 된다.
        * */
        Calculator c3 = (x, y) -> x + y;

        /* int와 int를 받아 int를 반환하는 것과 같은 흔한 작업은 자바 개발자들이 이미
        * java.util.function 패키지에 인터페이스를 만들어 두었다. */

        // BiFunction<T, U, R> : T와 U 타입의 두 개 인자를 받아 R 타입으로 반환하는 함수형 인터페이스
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        // 메소드 이름도 sumTwoNumber 가 아닌 apply로 표준화 되어있다.
        System.out.println(sum.apply(100, 200));

        List<String> names = Arrays.asList("홍길동", "유관순", "이순신");

        for(String name : names) {
            System.out.println(name);
        }

        // Consumer<T> : T타입의 인자를 하나 받고 아무것도 반환하지 않는(소비하는) 함수형 인터페이스
        // Consumer가 '행동의 설계도'이고, 람다는 그 '설계도를 따르는 실제 행동' 이라고 생각하면 된다.

        // 행동 : 'name'이라는 문자열을 받아서, 환영합니다 name 님! 출력
        Consumer<String> printName = name -> System.out.println("환영합니다, " + name + "님!");
        // names 리스트의 forEach 메소드에 그 기능(printName)을 전달하여 실행
        names.forEach(printName);

        names.forEach(name -> System.out.println("환영합니다, " + name + "님!!!!!"));
    }
}
