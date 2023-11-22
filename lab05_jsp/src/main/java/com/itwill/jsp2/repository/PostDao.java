package com.itwill.jsp2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                Post post = generatePostFromRS(rs);
                list.add(post);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return list;
    }
    
    // 새 포스트 작성에서 사용되는 SQL 문장
    private static final String SQL_INSERT = 
            "insert into POSTS (TITLE, CONTENT, AUTHOR) values (?, ?, ?)";
    
    // SQL_INSERT를 실행하는 메서드
    public int insert(Post post) {
        log.debug("insert(post={})", post);
        
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            log.debug(SQL_INSERT);
            
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setString(3, post.getAuthor());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    // POSTS 테이블에서 아이디(PK)로 검색:
    private static final String SQL_SELECT_BY_ID = 
            "select * from POSTS where ID = ?";
    
    // SQL_SELECT_BY_ID 문장을 실행하고 결과를 처리하는 메서드
    public Post select(Long id) {
        log.debug("select(id={})", id);
        
        Post post = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            log.debug(SQL_SELECT_BY_ID);
            
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) { // select 결과가 있으면
                // ResultSet에서 Post 객체를 만듦.
                post = generatePostFromRS(rs);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs); // 리소스 해제
        }
        
        return post;
    }
    
    // 포스트 아이디(PK)로 포스트 삭제하기
    private static final String SQL_DELETE_BY_ID = 
            "delete from POSTS where ID = ?";
    
    // SQL_DELETE_BY_ID를 실행하는 메서드
    public int delete(Long id) {
        log.debug("delete(id={})", id);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_BY_ID);
            log.debug(SQL_DELETE_BY_ID);
            stmt.setLong(1, id);
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    private static final String SQL_UPDATE = 
            "update POSTS set TITLE = ?, CONTENT = ?, MODIFIED_TIME = systimestamp "
            + "where ID = ?";
    
    public int update(Post post) {
        log.debug("update(post={})", post);
        
        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            log.debug(SQL_UPDATE);
            
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setLong(3, post.getId());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    // 제목으로 검색하기:
    private static final String SQL_SELECT_BY_TITLE = 
            "select * from POSTS where upper(TITLE) like ? order by ID desc";
    // 내용으로 검색하기:
    private static final String SQL_SELECT_BY_CONTENT = 
            "select * from POSTS where upper(CONTENT) like ? order by ID desc";
    // 제목 또는 내용으로 검색하기:
    private static final String SQL_SELECT_BY_TITLE_OR_CONTENT = 
            "select * from POSTS "
            + "where upper(TITLE) like ? or upper(CONTENT) like ? "
            + "order by ID desc";
    // 작성자로 검색하기:
    private static final String SQL_SELECT_BY_AUTHOR = 
            "select * from POSTS where upper(AUTHOR) like ? order by ID desc";
    
    public List<Post> search(String category, String keyword) {
        log.debug("search(category={}, keyword={})", category, keyword);
        
        List<Post> result = new ArrayList<>(); // 검색 결과를 저장할 리스트
        
        // 대/소문자 구분없이 like 검색을 하기 위해서
        String searchKeyword = "%" + keyword.toUpperCase() + "%";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            
            switch (category) {
            case "t":
                log.debug(SQL_SELECT_BY_TITLE);
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
                stmt.setString(1, searchKeyword);
                break;
            case "c":
                log.debug(SQL_SELECT_BY_CONTENT);
                stmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
                stmt.setString(1, searchKeyword);
                break;
            case "tc":
                log.debug(SQL_SELECT_BY_TITLE_OR_CONTENT);
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
                stmt.setString(1, searchKeyword);
                stmt.setString(2, searchKeyword);
                break;
            case "a":
                log.debug(SQL_SELECT_BY_AUTHOR);
                stmt = conn.prepareStatement(SQL_SELECT_BY_AUTHOR);
                stmt.setString(1, searchKeyword);
                break;
            }
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Post p = generatePostFromRS(rs);
                result.add(p);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return result;
    }
    
    private Post generatePostFromRS(ResultSet rs) throws SQLException {
        Long id = rs.getLong("ID");
        String title = rs.getString("TITLE");
        String content = rs.getString("CONTENT");
        String author = rs.getString("AUTHOR");
        Timestamp created = rs.getTimestamp("CREATED_TIME");
        Timestamp modified = rs.getTimestamp("MODIFIED_TIME");
        
        return new Post(id, title, content, author, created, modified);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }
    
}
