package ohgiraffers.section01.stringbuilder;

public class Application {
    public static void main(String[] args) {

        long starTime = System.nanoTime();  // 성능 측정 시작

        String str = "";
        for (int i = 0; i < 50000; i++) {
            str += i;
        }

        long endTime = System.nanoTime();   // 작업이 끝난 시간 기록

        System.out.println("String : " + (endTime - starTime));

        // StringBuilder : 가변을 이용한 효율적인 작업을 한다.
        // .append()는 기존 객체의 공간을 늘려 문자열을 추가하므로,
        // 반복문 안에서 문자열을 합칠 때 String 보다 월등히 빠른 성능을 보인다.
        // 따라서, 잦은 문자열 변경이 예상될 때는 StringBuilder를 사용하는 것이 좋다.
        starTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            sb.append(i);
        }

        endTime = System.nanoTime();
        System.out.println("StringBuilder : " + (endTime - starTime));

        StringBuilder sb2 = new StringBuilder("javamysql");

        /* delete(start, end) : 시작 인덱스부터 종료 인덱스 '전까지'의 문자열을 제거한다. */
        System.out.println(sb2.delete(4, 9));

        /* insert(index, value) : 지정한 인덱스에 값을 삽입한다. */
        System.out.println("insert() " + sb2.insert(0, "my"));

        /* reverse() :  문자열의 순서를 뒤집는다.*/
        System.out.println("reverse() : " + sb2.reverse());

        // 최종 결과물을 우리에게 익숙한 String 타입으로 변환
        String result = sb2.toString();
    }
}
