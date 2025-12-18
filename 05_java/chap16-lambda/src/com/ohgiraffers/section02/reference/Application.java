package com.ohgiraffers.section02.reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {

        // 정적(static) 메서드 참조
        // 문자열 -> 정수
        // [ 람다식 ]
        Function<String, Integer> parseInt = str -> Integer.parseInt(str);

        // [ 메소드 참조 ]
        // 클래스이름::정적메소드이름
        Function<String, Integer> reference_parseInt = Integer::parseInt;
        System.out.println("결과 : " + reference_parseInt.apply("123") * 2);

        // [ 람다식 ]
        Consumer<String> println = str -> System.out.println(str);

        // [ 메소드 참조 ]
        // 객체참조변수::인스턴스메소드이름
        Consumer<String> reference_println = System.out::println;
        reference_println.accept("Hello Method Reference!");

        List<String> subjects = Arrays.asList("java", "mysql", "jdbc", "css");
//        subjects.forEach(subject -> System.out.println(subject)); // 람다식
        subjects.forEach(System.out::println);  // 메소드 참조!

        // 불특정 다수 객체의 인스턴스 메소드 참조
        // [람다식]
        BiFunction<String, String, Boolean> equals = (s1, s2) -> s1.equals(s2);
        System.out.println(equals.apply("str","str"));
        // [ 메소드 참조 ]
        // 클래스이름::인스턴스메소드이름
        BiFunction<String, String, Boolean> reference_equals = String::equals;

        // [생성자 참조]
        // 생성자 참조는 '클래스이름::new' 형식으로 사용된다.
        // 어떤 생성자를 참조할지는 우리가 사용하는 함수형 인터페이스의 시그니처에 따라 컴파일러가 추론한다.
//        Supplier<Account> newAccount = () -> new Account();   // 람다식

        Supplier<Account> newAccount = Account::new;
        System.out.println("기본 생성자로 생성된 계좌 :" + newAccount.get());

        Function<String, Account> newAccountWithName = Account::new;
        System.out.println("이름과 함께 생성된 계좌 : " + newAccountWithName.apply("홍길동"));

        BiFunction<String, Integer, Account> newAccountFull = Account::new;
        System.out.println("모든 정보와 함께 생성된 계좌 : " + newAccountFull.apply("유관순", 10000));


    }
}
