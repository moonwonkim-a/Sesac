package com.ohgiraffers.section08.initblock;

public class Product {

    // 명시적 초기화
    private String name = "갤럭시";
    private int price = 1000000;
    private static String brand = "삼송";

    // 인스턴스 초기화 블럭 (생성자보다 먼저!!)
    {
        name = "아이폰";
        price = 1500000;
        brand = "사과";
        System.out.println("인스턴스 초기화 블럭 동작함...");
    }

    // 정적 초기화 블럭
    static {
        /*
        *  클래스 로드 시에 동작한다.
        *  동작 시점에는 인스턴스가 아무 것도 존재할 수 없기 때문에,
        *  존재하지 않는 인스턴스 변수에 초기화 하는 것은 시기상으로 불가능하다.
        * */
//        name = "아이뽄";

        brand = "헬지";
        System.out.println("정적 초기화 블럭 동작함...");
    }

    // 기본 생성자
    public Product() {
        System.out.println("기본 생성자 호출됨...");
    }

    // 매개변수 있는 생성자
    public Product(String name, int price, String brand){
        this.name = name;
        this.price = price;
        Product.brand = brand;
        System.out.println("매개변수 있는 생성자 호출됨...");
    }

    public String getInformation() {
        return "Product [" + this.name + this.price + Product.brand + "]";
    }
}
