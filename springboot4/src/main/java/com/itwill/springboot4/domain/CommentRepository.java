package com.itwill.springboot4.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // JPA query methods
//    List<Comment> findByPostOrderByIdDesc(Post post);
    List<Comment> findByPost(Post post, Sort sort);
    Page<Comment> findByPost(Post post, Pageable pageable);
    
}
