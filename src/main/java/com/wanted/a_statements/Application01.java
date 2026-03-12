package com.wanted.a_statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.wanted.common.JDBCTemplate.close;
import static com.wanted.common.JDBCTemplate.getConnection;

/*comment
 *  JDBC의 핵심적인 인터페이스 2가지
 *  1. Statement
 *  -SQL문을 저장하고 실행할 수 있는 기능을 가진 인터페이스
 *  2. Result
 *  -SQL문 결과 집합을 받아올 수 있는 인터페이스
 *  */

public class Application01 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            //statment는 Connection을 통해 객체 새성
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");

            while (rset.next()) {
                /*comment next(): ResultSet을 목록화시켜 행이 존재하면 True, 존재하지 않으면 False를 반환한다.*/
                System.out.println(rset.getString("EMP_ID") + "번 " + rset.getString("EMP_NAME") + "사원");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(con);
            close(rset);
        }
    }
}
