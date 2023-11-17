package com.itwill.jsp2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.datasource.DataSourceUtil;
import com.itwill.jsp2.domain.Post;
import com.zaxxer.hikari.HikariDataSource;

// MVC 아키텍쳐에서 영속성(persistence) 계층을 담당하는 클래스.
// DB CRUD(Create, Read, Update, Delete) 작업을 담당.
// DAO(Data Access Object)
public class PostDao {
    // slf4j의 로깅 기능 사용:
    private static final Logger log = LoggerFactory.getLogger(PostDao.class);
    
    // singleton 구현:
    private static PostDao instance = null;
    
    private HikariDataSource ds;
    
    private PostDao() {
        ds = DataSourceUtil.getInstance().getDataSource();
    }
    
    public static PostDao getInstance() {
        if (instance == null) {
            instance = new PostDao();
        }
        
        return instance;
    }
    
    // POSTS 테이블의 전체 레코드를 id의 내림차순 정렬로 검색.
    private static final String SQL_SELECT = 
            "select * from POSTS order by ID desc";
    
    // SQL_SELECT를 실행하는 메서드
    public List<Post> select() {
        List<Post> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection(); // 데이터 소스에서 커넥션 객체를 빌려옴.
            stmt = conn.prepareStatement(SQL_SELECT);
            log.debug(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) { // ResultSet 현재 위치에 레코드가 있으면
                Long id = rs.getLong("ID");
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                String author = rs.getString("AUTHOR");
                Timestamp created = rs.getTimestamp("CREATED_TIME");
                Timestamp modified = rs.getTimestamp("MODIFIED_TIME");
                
                Post post = new Post(id, title, content, author, created, modified);
                list.add(post);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close(); // 커넥션 객체를 데이터 소스에 반환.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
    
}
