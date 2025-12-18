package com.ohgiraffers.section01.init;

public class Application {
    public static void main(String[] args) {

        Car car1 = new Car("페라리", 300);
        Car car2 = new Car("람보르기니", 350);
        Car car3 = new Car("롤스로이스", 250);
        Car car4 = new Car("부가티베이론", 400);
        Car car5 = new Car("포터", 200);

        car1.driveMaxSpeed();
        car2.driveMaxSpeed();
        car3.driveMaxSpeed();
        car4.driveMaxSpeed();
        car5.driveMaxSpeed();

        /* 객체배열은 레퍼런스변수들을 보관하는 배열이다.
        * 동일한 타입의 여러 객체들을 하나의 묶음으로 관리하여 연속척으로 처리할 때 유용하다.
        * */
        Car[] carArray = new Car[5];

        /*
        * 배열을 선언만 하면 기본값으로 초기화된다.
        * 기본자료형(int, double 등)은 0, 0.0으로 초기화 되지만,
        * 참조자료형(Car, String 등)의 기본값은 null 이다.
        * */
        System.out.println(carArray[0]);    // null

        try{
            carArray[0].driveMaxSpeed();
        } catch (NullPointerException e) {
            System.out.println("!!! NullPointerException발생!!");
        }

        carArray[0] = new Car("페라리", 300);
        carArray[1] = new Car("람보르기니", 350);
        carArray[2] = new Car("롤스로이스", 250);
        carArray[3] = new Car("부가티베이론", 400);
        carArray[4] = new Car("포터", 200);

        carArray[0].driveMaxSpeed();

        for (int i = 0; i < carArray.length; i++) {
            carArray[i].driveMaxSpeed();
        }
        System.out.println();

        // 객체배열도 선언과 동시에 리터럴({})로 초기화 할 수 있다.
        Car[] carArray2 = {
                new Car("페라리", 300),
                new Car("람보르기니", 350),
                new Car("롤스로이스", 250)
        };

        // 향상된 for문 사용
        // carArray2 객체 배열에서 객체를 하나씩 꺼내 'car'라는 이름의 임시 변수에 '복사' 해주는 방식
        // 주의: 실제 car가 복사되는것이 아니고 car를 가리키는 '주소값'만 복사된다.
        for(Car car : carArray2) {
            car.driveMaxSpeed();
        }

        /* 가장 빠른 차를 찾아라!!! */
        /* 1. 가장 빠르다고 '가정'할 차를 담을 변수 선언(첫 번째 차로 초기화) */
        Car fastestCar = carArray[0];

        /* 2. 반복문을 돌며 현재까지 가장 빨랐던 차(fastestCar)와 다음 차를 비교 */
        for( int i = 1; i < carArray.length; i++) {
            if(carArray[i].getMaxSpeed() >  fastestCar.getMaxSpeed()) {
                // 만약 다음 차가 더 빠르다면, '가장 빠른 차' 변수를 그 차로 교체!!
                fastestCar = carArray[i];
            }

        }
        System.out.println("가장 빠른 자동차는 " + fastestCar.getModelName() + " 이며 시속은" + fastestCar.getMaxSpeed()+"입니다.");
    }

}
