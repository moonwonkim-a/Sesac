package ohgiraffers.section02.superkeyword;

public class Product {

    private String code;
    private String name;
    private int price;

    // 기본 생성자
    public Product() {
        System.out.println("Product 기본 생성자 호출");
    }

    // 모든 필드를 초기화하는 매개변수 있는 생성자
    public Product(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
        System.out.println("Product 매개변수 있는 생성자 호출");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInformation() {
        return "Product [code= " + code + ", name= " + name + ", price= "+ price +"]";
    }

}
