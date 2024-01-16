package com.itwill.springboot4.domain;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // JPA query methods
//    List<Comment> findByPostIdOrderByIdDesc(Long postId);
    List<Comment> findByPostId(Long postId, Sort sort);
    
}
