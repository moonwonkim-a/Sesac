package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        /* 1. Connection 생성 */
        Connection con = getConnection();
        /* 2. Statement 생성 */
        Statement stmt = null;
        /* 3. ResultSet 선언 */
        ResultSet rset = null;
        /* 4. Connection의 createStatement()를 이용한 Statement 인스턴스 생성 */
        try {
            stmt = con.createStatement();

            // Scanner로 사번 입력받아 해당하는 사원의 아이디와 이름 조회 쿼리 작성
            Scanner sc = new Scanner(System.in);
            System.out.print("사번을 입력하세요 : ");
            String empID = sc.nextLine();
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empID + "'";
            /* 200' or '1'='1 을 입력하면 조건절이 무조건 True가 되어 모든 직원의 정보를 반환 받을 수 있다. */
            /* SQL Injection(SQL 주입)공격 : 사용자가 입력 필드를 통해 데이터베이스에 임의의 SQL코드를 삽입하여 실행하는 공격 기법 */

            System.out.println(query);
            /* 5. executeQuery()로 쿼리를 실행하고 ResultSet으로 반환 받음 */
            rset = stmt.executeQuery(query);

            /* 6. ResultSet에 담긴 결과물을 컬럼 이름을 이용해 꺼내어 출력 */
            while(rset.next()){
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            } /* else {
                System.out.println("해당 사원의 조회 결과가 없습니다.");
            }*/
            /* 7. 사용한 자원 반납 */
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
