package com.itwill.jsp2.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.jdbc.OracleDriver;

/*
 * JUnit 테스트(자바 단위 테스트)를 하기 위한 클래스 작성.
 * main 메서드를 작성하지 않음.
 * @Test 애너테이션을 사용한 메스드를 작성.
 * Run As->JUnit Test를 실행하면, junit-jupiter-engine에서 테스트 메서드를 실행.
 */
public class JdbcTest {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";
    private static final Logger log = LoggerFactory.getLogger(JdbcTest.class);
    
    /*
     * 테스트 메서드 작성:
     * @Test 애너테이션을 사용.
     * public void로 선언. 파라미터를 선언하지 않아야 함.
     */
    @Test
    public void test() throws SQLException {
        // 1. JDBC 라이브러리(드라이버)를 등록:
        DriverManager.registerDriver(new OracleDriver());
        log.debug("오라클 JDBC 드라이버 등록 성공");
        
        // 2. 데이터베이스와 Connection을 맺음:
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        // 개발자가 정상 결과라고 예상(expect)하는 값을 테스트:
        Assertions.assertNotNull(conn);
        log.debug("conn={}", conn);
        
        // 리소스 해제:
        conn.close();
    }

}
