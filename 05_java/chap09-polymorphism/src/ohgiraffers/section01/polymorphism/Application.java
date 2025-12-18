package ohgiraffers.section01.polymorphism;

public class Application {
    public static void main(String[] args) {

        /* [다형성]
        * 하나의 참조 변수(부모 타입)나 메소드 호출이,
        * 실제 참조하는 객체가 무엇이냐에 따라 다양한 방식으로 동작하는 것*/

        // 다형성이 없다면?
        ZooKeeper badZooKeeper = new ZooKeeper();
        badZooKeeper.feed(new Cat());   // 고양이 객체를 넘겨줌
        badZooKeeper.feed(new Tiger()); // 호랑이 객체를 넘겨줌

        // 다형성 적용(업캐스팅) : 자식 객체를 부모 타입의 변수에 할당
        // 부모 타입의 참조 변수로 자식 타입의 인스턴스를 가리킬 수 있다.
        Animal a1 = new Cat();
        Animal a2 = new Tiger();

        // [동적 바인딩]
        // 컴파일 시점에는 부모(Animal)의 메소드를 호출하는 것으로 보이지만,
        // 실행 시점(Runtime)에는 참조 변수가 실제로 가리키는 객체(Cat, Tiger)의
        // 오버라이딩 된 메소드가 실행되는 원리이다.
        a1.cry();
        a2.cry();

//        a1.jump();    // 'Animal' 리모콘이므로 Cat만 가진 jump() 호출 불가

        ((Cat)a1).jump();   // 다운캐스팅 : 명시적으로 타입 강제 변환

//        ((Cat)a2).cry();    // Tiger를 Cat으로 바꾸려 하면 ClassCastException 발생!!

        /* 위와 같은 위험한 상황을 방지하기 위해, 형변환 전에는 반드시
        instanceof 연산자로 가리키는 객체를 확인하고 실행하는 것이 안전하다. */
        System.out.println("a1은 Tiger 타입인가?" + (a1 instanceof Tiger));

        if (a1 instanceof Cat) {
            System.out.println("a1은 고양이가 맞군요! 점프!");
            ((Cat)a1).jump();
        }

        /* 다형성을 활용한 객체 배열 */
//        Cat[] cat = new Cat[5];
        Animal[] animals = new Animal[5];
        animals[0] = new Cat();
        animals[1] = new Tiger();
        animals[2] = new Tiger();
        animals[3] = new Cat();
        animals[4] = new Tiger();

        // 모든 동물들아 울어봐 (동적 바인딩 활용)
        for(Animal animal : animals) {
            animal.cry();
        }

        // 각자 할 수 있는 장기자랑 해봐 (instanceof와 다운캐스팅 활용)
        for(Animal animal : animals) {
            if (animal instanceof Cat) {
                ((Cat)animal).jump();
            } else if (animal instanceof Tiger) {
                ((Tiger)animal).bite();
            }
        }
        // 매개변수의 다형성 + 동적 바인딩 활용
        ZooKeeper goodZooKeeper = new ZooKeeper();
        for (Animal animal : animals) {
            goodZooKeeper.feed(animal);
        }

    }
}
