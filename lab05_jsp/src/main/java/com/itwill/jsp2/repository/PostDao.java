package com.itwill.jsp2.repository;

import com.itwill.jsp2.datasource.DataSourceUtil;
import com.zaxxer.hikari.HikariDataSource;

// MVC 아키텍쳐에서 영속성(persistence) 계층을 담당하는 클래스.
// DB CRUD(Create, Read, Update, Delete) 작업을 담당.
// DAO(Data Access Object)
public class PostDao {
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
}
