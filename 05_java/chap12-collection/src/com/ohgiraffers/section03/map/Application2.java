package com.ohgiraffers.section03.map;

import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {

        /* Properties
        * - HashMap을 상속받아 구현한 클래스로, Map의 특징을 그대로 가진다.
        * - 가장 큰 차이점은, Key와 Value가 모두 문자열(String)형태 로만 저장 가능하다는 것이다.
        * - 주로 프로그램의 '설정 정보'를 관리하는데 사용된다. (예: DB 연결정보, 환경설정 값)
        * */

        Properties prop = new Properties();

        prop.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("url", "jdbc:mysql://localhost/menu");
        prop.setProperty("user", "ohgiraffers");
        prop.setProperty("password", "ohgiraffers");

        System.out.println(prop);

        String driver = prop.getProperty("driver");
        String user = prop.getProperty("user");

        System.out.println(driver);
        System.out.println(user);
    }
}
