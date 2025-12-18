package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {
    public static void main(String[] args) {

        /* XML 파일에 별도로 입력한 sql 문을 통해 처리 */
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* 한 행의 정보를 담을 DTO */
        EmployeeDTD row = null;

        /* 여러 DTO 타입의 객체를 담을 List */
        List<EmployeeDTD> empList = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사원의 성을 입력하세요 : ");
        String empName = sc.nextLine();

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section02/preparedstatement/employee-query.xml"));

            String query = prop.getProperty("selectEmpByFamilyName");
            System.out.println("query : " + query);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1,empName);
            rset = pstmt.executeQuery();

            empList = new ArrayList<>();

            while(rset.next()) {
                // 각 행의 데이터를 담을 빈 EmployeeDTO
                row = new EmployeeDTD();
                // ResultSet에서 컬럼 값을 꺼내 DTO 각 필드에 채워넣는다.
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setEmail(rset.getString("EMAIL"));
                row.setPhone(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEntDate(rset.getDate("ENT_DATE"));
                row.setEntYn(rset.getString("ENT_YN"));

                // 정보가 채워진 DTO를 List에 추가
                empList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        for(EmployeeDTD emp : empList){
            System.out.println(emp);
        }
    }

}
