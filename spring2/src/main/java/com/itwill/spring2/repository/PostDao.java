package com.itwill.spring2.repository;

import java.util.List;

import com.itwill.spring2.domain.Post;

public interface PostDao {

    List<Post> selectOrderByIdDesc();
    
}
