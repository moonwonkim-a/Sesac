package com.ohgiraffers.section03.functionalinterface;

import java.time.LocalDateTime;
import java.util.function.*;

public class Application {
    public static void main(String[] args) {

        /* 표준 함수형 인터페이스 */

        // 1. Consumer<T> : T 타입의 인자를 받아 '소비'만 한다. (반환값 없음)
        Consumer<String> printer = message -> System.out.println(message);
        // accept() : Consumer가 값을 소비하기 위해 사용하는 메소드
        printer.accept("Hello, Consumer!");

        // 2. Supplier<T> : 아무것도 받지 않고, T 타입의 객체를 '공급' 한다.
        Supplier<LocalDateTime> timeSupplier = () -> LocalDateTime.now();
        // get() : Supplier로부터 값을 공급받기 위해 사용하는 메소드
        System.out.println("현재 시간 : " + timeSupplier.get());

        // 3. Function<T, R> : T 타입의 인자를 받아, R 타입의 객체로 '변환'하여 반환한다.
        Function<String, Integer> lengthFunction = str -> str.length(); // int -> Integer로 Auto-Boxing
        // apply() : Function의 변환 기능을 입력값에 적용하기 위해 사용하는 메소드
        System.out.println(lengthFunction.apply("Hello, Function!"));

        // 4. Operator<T> : 동일한 T 타입의 인자들을 받아 '연산'하고, 같은 T 타입으로 반환한다.
        BinaryOperator<Integer> sumOperator = (num1, num2) -> num1 + num2;
        // Function을 상속받았기 때문에 똑같이 apply() 사용
        System.out.println(sumOperator.apply(100, 200));

        // 5. Predicate<T> : T 타입의 인자를 받아 '검사'하고, boolean으로 '판단' 하여 반환한다.
        Predicate<String> isNotEmpty = str -> str != null && !str.isEmpty();
        // test() :  Predicate의 판단 기능을 실행하기 위해 사용
        System.out.println(isNotEmpty.test("Hello!"));
        System.out.println(isNotEmpty.test(""));

    }
}
