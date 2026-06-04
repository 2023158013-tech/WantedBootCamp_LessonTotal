package com.wanted.b_preparedstatements;

import java.sql.*;

import static com.wanted.common.JDBCTemplate.close;
import static com.wanted.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {

        /*comment
        *  Statement는 SQL 쿼리문을 실행할 때마다 SQL문이 DBMS에 전송되어 DBMS에서 SQL문을 파싱(번역)하고 컴파일을 하는 과정을 거치게 된다.
        *  PrepareStatement는 최초에 한번 실행 시, SQL구문을 파싱하고 컴파일하는 것은 동일하지만 동일한 구문을 여러 번 실행하면 최초에 컴파일한
        *  SQL을 재사용하게 된다.
        *  따라서 파싱하고 컴파일하는 과정을 생략하여 성능이 향상된다.
        *  */

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            //statment는 Connection을 통해 객체 새성
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");

            rset = pstmt.executeQuery();

            while (rset.next()) {
                /*comment next(): ResultSet을 목록화시켜 행이 존재하면 True, 존재하지 않으면 False를 반환한다.*/
                System.out.println(rset.getString("EMP_ID") + "번 " + rset.getString("EMP_NAME") + "사원");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
            close(rset);
        }
    }
}
