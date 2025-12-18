package com.ohgiraffers.section02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        /* FileInputStream : File로부터 데이터를 1바이트씩 읽어오는 스트림
        * 주요 대상 : 모든 종류의 파일(이미지, 영상, 텍스트 등) */
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("src/com/ohgiraffers/section02/testInputStream.txt");

            int value;

            // read() : 파일에 기록된 값을 1바이트씩 읽어온다. 더 이상 읽을 데이터가 없으면 -1을 반환
            while ((value = fin.read()) != -1) {

                System.out.println(value);

                System.out.println((char) value);
            }

            System.out.println("파일의 길이 : " + new File("src/com/ohgiraffers/section02/testInputStream.txt").length());

            // 파일의 길이 만큼의 byte 배열을 만든다.
            int fileSize = (int) new File("src/com/ohgiraffers/section02/testInputStream.txt").length();
            byte[] bar = new byte[fileSize];

            // 파일의 내용을 읽어서 byte 배열에 기록해준다.
            fin.read(bar);

            for(int i = 0; i < bar.length; i++) {
                System.out.println((char)bar[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } finally {
            // 사용이 끝난 스트림은 반드시 닫아줘야 한다.(자원 반납)
            if(fin != null){
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
