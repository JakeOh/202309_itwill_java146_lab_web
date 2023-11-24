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
import com.itwill.jsp2.dto.UserSignInDto;
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
    
    // 로그인 체크 SQL
    private static final String SQL_SIGN_IN = 
            "select * from USERS where USERID = ? and PASSWORD = ?";
    
    // userid와 password가 일치하면 User 객체를, 일치하지 않으면 null을 리턴.
    public User selectByUseridAndPassword(UserSignInDto dto) {
        log.debug("selectByUseridAndPassword(dto={})", dto);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SIGN_IN);
            log.debug(SQL_SIGN_IN);
            
            stmt.setString(1, dto.getUserid());
            stmt.setString(2, dto.getPassword());
            
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = generateUserFromRS(rs);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return user;
    }
    
    // 사용자가 포스트를 작성했을 때 포인트를 지급:
    private static final String SQL_UPDATE_POINT = 
            "update USERS set POINTS = POINTS + ? where USERID = ?";
    
    public int updatePoints(int point, String userid) {
        log.debug("updatePoints(point={}, userid={})", point, userid);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_POINT);
            log.debug(SQL_UPDATE_POINT);
            
            stmt.setInt(1, point);
            stmt.setString(2, userid);
            
            result = stmt.executeUpdate();
            log.debug("포인트 업데이트 result = {}", result);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    private User generateUserFromRS(ResultSet rs) throws SQLException {
        Long id = rs.getLong("ID");
        String userid = rs.getString("USERID");
        String password = rs.getString("PASSWORD");
        String email = rs.getString("EMAIL");
        Long points = rs.getLong("POINTS");
        
        return User.builder()
                .id(id).userid(userid).password(password).email(email).points(points)
                .build();
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
