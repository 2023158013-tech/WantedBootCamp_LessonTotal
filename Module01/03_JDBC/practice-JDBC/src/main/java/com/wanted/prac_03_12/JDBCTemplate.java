package com.wanted.prac_03_12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection() {
        Connection con = null;
        /*comment properties 파일을 읽기 위한 객체 생성*/
        Properties prop = new Properties();

        try {

            prop.load(new FileReader("src/main/java/com/wanted/prac_03_12/jdbc-config.properties"));

            System.out.println("prop = " + prop);

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            //사용할 드라이버 등록
            Class.forName(driver);
            //Connection은 인터페이스이기 때문에 직접 객체를 생성하지 못한다.
            //따라서 Connection을 생성해주는 DriverManager를 통해 우리가 사용할 DB의 정보를 넘겨주며 객체를 생성한다.
            con = DriverManager.getConnection(url, user, password);
            System.out.println("con = " + con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    //사용한 Connection을 닫아주는 메소드
    public static void close(Connection con) {
        try {
            //con이 null이 아니며 닫혀있지 않다면
            if(con != null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Statement stmt) {
        try {
            //con이 null이 아니며 닫혀있지 않다면
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet rset) {
        try {
            //con이 null이 아니며 닫혀있지 않다면
            if(rset != null && !rset.isClosed()){
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
