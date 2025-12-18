package ohgiraffers.section02.superkeyword;

public class Application {
    public static void main(String[] args) {

        Product product = new Product();
        System.out.println(product.getInformation());

        Product product2 = new Product("S-0123", "갤럭시", 2300000);
        System.out.println(product2.getInformation());

        Computer computer = new Computer("S-9123", "갤럭시", 2300000, "512", 12);
        System.out.println(computer.getInformation());

        SmartPhone smartPhone = new SmartPhone("s-234", "아이폰", 2500000, "kt");
        System.out.println(smartPhone.getInformation());

    }
}
