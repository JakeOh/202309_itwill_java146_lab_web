package com.itwill.jsp2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.datasource.DataSourceUtil;
import com.itwill.jsp2.domain.User;
import com.zaxxer.hikari.HikariDataSource;

public class UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);
    
    private final HikariDataSource ds = DataSourceUtil.getInstance().getDataSource();
    
    private static UserDao instance = null;
    
    private UserDao() {}
    
    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        
        return instance;
    }

    // 회원 가입 SQL
    private static final String SQL_SIGN_UP = 
            "insert into USERS (USERID, PASSWORD, EMAIL) values (?, ?, ?)";
    
    // 회원 가입 메서드
    public int insert(User user) {
        log.debug("insert(user={})", user);
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SIGN_UP);
            log.debug(SQL_SIGN_UP);
            stmt.setString(1, user.getUserid());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }
    
}
