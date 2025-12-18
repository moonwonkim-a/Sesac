package ohgiraffers.section01.extend;

public class RacingCar extends Car {

    @Override
    public void run() {
        super.run();    // super는 부모를 가리키는 키워드
                        // 부모의 run() 메소드를 먼저 실행시켜라!!
        System.out.println("레이싱카가 전속력으로 질주합니다!!!!!!!");
    }
}
