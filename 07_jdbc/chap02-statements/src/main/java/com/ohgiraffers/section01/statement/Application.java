package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {

        Connection con = getConnection();

        // 쿼리를 운반하고 결과를 반환하는 객체
        Statement stmt = null;
        // select 결과 집합을 받아 올 인터페이스
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("select EMP_ID, EMP_NAME FROM EMPLOYEE");

            while(rset.next()){
                /* next() : ResultSet 커서 위치를 내리면서 다음 행이 존재하면 true, 존재하지 않으면 false 반환
                *  getXXX(컬럼명) : 커서가 가리키는 행의 컬럼을 XXX 데이터 타입으로 반환한다. */
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 맨 마지막에 열렸던 것 부터 순서대로 닫아준다.
            close(rset);
            close(stmt);
            close(con);

        }
    }
}
