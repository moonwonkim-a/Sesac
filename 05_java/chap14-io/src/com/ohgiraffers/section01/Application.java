package com.ohgiraffers.section01;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        /*
        * 파일 클래스를 이용해서 인스턴스를 생성한다.
        * 대상 파일이 존재하지 않아도 인스턴스를 생성할 수 있다.
        * */
        File file = new File("src/com/ohgiraffers/section01/test.txt");

        try {
            // 파일 생성 후 성공 실패 여부를 boolean으로 리턴
            boolean createSuccess = file.createNewFile();

            System.out.println(createSuccess);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("파일의 크기 : " + file.length() + "byte");
        System.out.println("파일의 경로 : " + file.getPath());
        System.out.println("파일의 절대 경로 : " + file.getAbsolutePath());

        boolean deleteSuccess = file.delete();

        System.out.println(deleteSuccess);
    }
}
