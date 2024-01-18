package com.itwill.springboot4.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long>, PostQuerydsl {
    
    // JPA Query methods
    Page<Post> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Post> findByContentContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Post> findByAuthorContainingIgnoreCase(String keyword, Pageable pageable);

    // findByTitleContainingOrContentContainingAllIgnoreCase()
    // JPQL(Java Persistence Query Language)
    @Query("select p from Post p "
            + "where upper(p.title) like upper('%' || :keyword || '%') "
            + "or upper(p.content) like upper('%' || :keyword || '%')")
    Page<Post> findByTitleOrContent(@Param("keyword") String keyword, Pageable pageable);
    
}
