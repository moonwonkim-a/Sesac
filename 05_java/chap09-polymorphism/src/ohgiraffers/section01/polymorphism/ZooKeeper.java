package ohgiraffers.section01.polymorphism;

public class ZooKeeper {

    // 다형성을 사용하지 않았을 때 -> 각 동물 타입에 맞춰 별도의 먹이주기 메소드를 만들어야 한다.
    public void feed(Cat cat) {
        System.out.println("[고양이에게]");
        cat.eat();
    }
    public void feed(Tiger tiger) {
        System.out.println("[호랑이에게]");
        tiger.eat();
    }

    // 다형성을 적용했을 때 -> 부모(Animal) 타입의 매개변수 하나만 있으면,
    // 그 어떤 자식 클래스(Cat, Tiger)도 다 받을 수 있다.  ->  매개변수의 다형성
    public void feed(Animal animal) {
        System.out.print("[다형성 적용]");
        animal.eat();
        // animal 변수가 실제 어떤 자식 인스턴스를 가리키든, 그 인스턴스의 오버라이딩 된 eat() 실행
    }

}
