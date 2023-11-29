package com.itwill.spring2.repository;

import java.util.List;

import com.itwill.spring2.domain.Post;

public interface PostDao {

    List<Post> selectOrderByIdDesc();
    Post selectById(long id);
    int insert(Post post);
    int update(Post post);
    int delete(long id);
    
}
