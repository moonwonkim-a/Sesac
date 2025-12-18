package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

        /* finally 블럭에서 사용하기 위해 try 블럭 밖에 선언 */
        Connection con = null;
        /* 라이브러리에 있는 클래스를 활용하여 드라이버를 로드하고
         * 어떤 드라이버를 사용할지 인식시킨다. */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            /* getConnection 스태틱 메소드를 이용해서 Connection(통로) 생성 */
            con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "ohgiraffers", "ohgiraffers");
            System.out.println("con : " + con);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
