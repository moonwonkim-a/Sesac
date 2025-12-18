package com.ohgiraffers.section02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {

        /* FileReader :  byte단위가 아닌 character 단위로 읽어온다
        * 따라서 2바이트던 3바이트던 글자 단위로 읽어오기 때문에 한글을 정상적으로 읽어올 수 있다.
        * 주요 대상 : 텍스트 파일(한글 등 다국어 처리 용이) */

        try(FileReader fr = new FileReader("src/com/ohgiraffers/section02/testReader.txt")) {

            int value;
            while((value = fr.read()) != -1) {
                System.out.println((char) value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
