package com.itwill.jsp2.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.jdbc.OracleDriver;

public class JdbcTest {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";
    private static final Logger log = LoggerFactory.getLogger(JdbcTest.class);
    
    @Test
    public void test() throws SQLException {
        // 1. JDBC 라이브러리(드라이버)를 등록:
        DriverManager.registerDriver(new OracleDriver());
        log.debug("오라클 JDBC 드라이버 등록 성공");
        
        // 2. 데이터베이스와 Connection을 맺음:
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        log.debug("conn=" + conn);
        
        // 리소스 해제:
        conn.close();
    }

}
