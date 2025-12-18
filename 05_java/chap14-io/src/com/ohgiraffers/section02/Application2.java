package com.ohgiraffers.section02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {
        /*
        * FileOutputStream : 데이터를 1바이트씩 파일에 출력하는 스트림
        * */
        // try-with-resources 구문 : try 괄호가 끝나면 자동으로 close()가 호출된다.
        try (FileOutputStream fout = new FileOutputStream("src/com/ohgiraffers/section02/testOutputStream.txt")) {
            // 1. 1바이트 쓰기
            fout.write(97); // 아스키코드 97 -> a

            /* byte 배열을 이용해서 한번에 기록할 수도 있다.
            * 10 : 개행문자 (엔터) */
            byte[] bar = new byte[] {98, 99, 100, 101, 102, 10};

            fout.write(bar);

            // 1번 인덱스부터 3의 길이만큼 파일에 내보내기
            fout.write(bar, 1, 3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
