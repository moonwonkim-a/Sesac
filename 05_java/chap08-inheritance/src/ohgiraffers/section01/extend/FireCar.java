package ohgiraffers.section01.extend;

public class FireCar extends Car {

    public FireCar() {
        super();    // 부모 클래스의 생성자를 호출하는 구문(컴파일러가 자동으로 추가)
        System.out.println("FireCar의 기본 생성자 호출..");
    }
    /*
    * @Override 어노테이션
    * 부모 클래스로부터 물려받은 메소드를 내 입맛에 맞게 고쳐쓰는 것(재정의)를 의미한다.
    * 이 어노테이션을 붙이면, 컴파일러가 오버라이딩 규칙을 잘 지켰는지 검사해준다.(실수 방지)
    * */
    @Override
    public void soundHorn() {
        if(isRunning()) {
            System.out.println("빠아아아앙!!!@@@!@!@!@!@");
        } else {
            System.out.println("소방차가 앞으로 갈 수 없습니다 비키세요 비켜요~~~~");
        }
    }
    // 부모에게는 없던, FireCar 만의 고유한 기능 추가 (확장)
    public void sparyWater() {
        System.out.println("불난 곳을 발견했습니다. 물을 뿌립니다 ==================>>>>>>");
    }
}
