package ohgiraffers.section02.superkeyword;

// Product 클래스 상속 받는다.
public class SmartPhone extends Product {

    // 고유 필드를 하나 추가
    private String agency;

    // 부모 필드 포함 모든 필드를 초기화하는 생성자
    public SmartPhone(String code, String name, int price, String agency) {
        super(code, name, price);
        this.agency = agency;
        System.out.println("SmartPhone 생성자 호출됨");
    }

    // getInformation() 메소드 오버라이딩
    @Override
    public String getInformation() {

        return super.getInformation() + ", SmartPhone [ agency=" + agency + "]";
    }
}
