package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application2 {
    public static void main(String[] args) {

        /*
        * 형변환 보조스트림 (InputStreamReader / OutputStreamWriter)
        * 기본 스트림이 byte 기반 스트림이고, 보조 스트림이 char 기반 스트림인 경우 사용
        * */

        // 1. 기본 스트림: System.in (바이트 스트림)
        // 2. 1차 필터 : new InputStreamReader(System.in) (바이트 -> 문자로 변환)
        // 3. 2차 필터 : new BufferedReader (버퍼기능 추가)

         try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
             System.out.print("문자열 입력 : ");
             String value = br.readLine();  // 키보드 입력을 한줄씩 읽을 수 있다!!!
             System.out.println("value : " + value);
         } catch (IOException e) {
             e.printStackTrace();
         }

         /* 출력을 위한것도 마찬가지로 사용 가능 */
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            bw.write("java mysql jdbc");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
