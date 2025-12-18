package ohgiraffers.section01.wrapper;

public class Application {
    public static void main(String[] args) {

        String heighStr = "175.5";
        String weightStr = "69.3";
        System.out.println("입력받은 키 : " + heighStr);
        System.out.println("입력받은 몸무게 : " + weightStr);

        System.out.println(heighStr + weightStr);

        // 파싱 : 문자열 데이터를 실제 해당 타입의 기본 자료형으로 변환하는 과정
        // Wrapper 클래스들은 'parse자료형()' 형태의 static 메소드를 제공한다.
        double height = Double.parseDouble(heighStr);
        double weight = Double.parseDouble(weightStr);

        double bmi = weight / ((height / 100) * (height / 100));
        System.out.println("계산된 bmi 지수 : " + bmi);

        /* 기본 자료형이 아닌 '객체' 형태로 데이터를 다뤄야 할 때가 있다.
        * 이때 기본 자료형을 감싸서(Wrap) 객체로 만드는 것을 'Boxing(박싱)'이라고 한다. */
        // int -> Integer
        // char -> Character

        // Integer num = new Integer(10); // 예전 방식!! (지금은 사용 비권장)

        Integer age = 20;   // Auto-Boxing :  컴파일러가 Integer.valueOf(20)으로 자동 변환.

        int unboxedAge = age;   // Auto-Unboxing : 컴파일러가 age.intValue()로 자동 변환

        //Wrapper 클래스 객체의 값 비교는 반드시 .equals()를 사용해야 한다. ( == 연산자는 주소 비교)
        Integer num1 = 10;
        Integer num2 = 10;
        System.out.println(num1 == num2);   // true (byte범위(-128 ~ 127) 캐싱으로 인해 예외적으로 true

        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println(num3 == num4);   // false (범위를 벗어나면 다른 객체로 생성됨)

        System.out.println(num3.equals(num4));

        /* 숫자 데이터를 다시 문자열로!!
        * 계산이 끝난 데이터를 화면에 표시하거나, 저장하려면 다시 문자열로 변환해야 한다.
        * 1. String.valueOf(값)
        * 2. 값 + "" (간편한 방법)
        * */

        String bmiStr1 = String.valueOf(bmi);
        String bmiStr2 = bmi + "";

        System.out.println("당신의 BMI는 " + bmiStr1 + "입니다.");




    }
}
