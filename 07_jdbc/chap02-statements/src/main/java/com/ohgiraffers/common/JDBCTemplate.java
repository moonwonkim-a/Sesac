package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {

        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);

            // url과 Properties 객체를 통째로 넘길 수도 있다.
            // "user", "password" 키를 찾아서 사용한다.
            con = DriverManager.getConnection(url,prop);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 성공적으로 생성된 Connection 반환
        return con;
    }

    public static void close(Connection con) {

        try {
            // con.isClosed() 닫혀있으면 true를 반환하므로, !를 붙여 "닫혀있지 않으면" 조건으로 만든다.
            if (con != null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {

        try{
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // 오버로딩 : 같은 이름의 메소드가 매개변수의 타입이나 개수가 다르면 오버로딩이다.
    public static void close(ResultSet rset){

        try{
            if (rset != null && !rset.isClosed()){
                rset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
