package com.wanted.prac_03_12;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.wanted.prac_03_12.JDBCTemplate.close;
import static com.wanted.prac_03_12.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 부서 코드: ");
        String dept_code = sc.nextLine();
        System.out.println("조회할 최소 급여: ");
        int salary = sc.nextInt();

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        List<EmployeeDTO> empList = new ArrayList<>();
        Properties prop = new Properties();

        try {
            prop.loadFromXML(
                    new FileInputStream("src/main/java/com/wanted/prac_03_12/employee-query.xml")
            );

            String query = prop.getProperty("selectByDeptAndSalary");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, dept_code);
            pstmt.setInt(2, salary);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                EmployeeDTO emp = new EmployeeDTO();
                emp.setEmpId(rset.getString("EMP_ID"));
                emp.setEmpName(rset.getString("EMP_NAME"));
                emp.setEmpNo(rset.getString("EMP_NO"));
                emp.setEmail(rset.getString("EMAIL"));
                emp.setPhone(rset.getString("PHONE"));
                emp.setDeptCode(rset.getString("DEPT_CODE"));
                emp.setJobCode(rset.getString("JOB_CODE"));
                emp.setSalLevel(rset.getString("SAL_LEVEL"));
                emp.setSalary(rset.getInt("SALARY"));
                emp.setBonus(rset.getDouble("BONUS"));
                emp.setManagerId(rset.getString("MANAGER_ID"));
                emp.setHireDate(rset.getDate("HIRE_DATE"));
                emp.setEntDate(rset.getDate("ENT_DATE"));
                emp.setEntYn(rset.getString("ENT_YN"));

                empList.add(emp);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
            close(rset);
        }

        if (empList.isEmpty()) {
            System.out.println("조회 결과가 없습니다.");
        } else {
            for(EmployeeDTO e : empList) {
                System.out.println(e);
            }
        }

    }
}
