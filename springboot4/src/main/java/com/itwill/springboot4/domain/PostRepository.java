package com.itwill.springboot4.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    
    Page<Post> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);

}
