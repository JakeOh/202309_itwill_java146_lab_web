package com.itwill.springboot4.domain;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostQuerydslImpl extends QuerydslRepositorySupport
    implements PostQuerydsl {

    public PostQuerydslImpl() {
        super(Post.class);
        //-> 상위클래스 QuerydslRepositorySupport는 기본 생성자를 갖고 있지 않기 때문에
        // 아규먼트를 갖는 생성자를 명시적으로 호출해야만 함.
        // QuerydslRepositorySupport 생성자의 아규먼트는 도메인 클래스(엔터티 클래스).
    }

    @Override
    public Post searchById(Long id) {
        // id(PK)로 포스트 1개를 검색하는 기능.
        // select p.* from posts p where p.id = ?
        log.info("searchById(id={})", id);
        
        QPost post = QPost.post;
        JPQLQuery<Post> query = from(post); // select p from Post p
        query.where(post.id.eq(id)); // where p.id = ?
        Post entity = query.fetchOne();
        
        return entity;
    }

    @Override
    public List<Post> searchByTitleOrContent(String keyword) {
        log.info("searchByTitleOrContent(keyword={})", keyword);
        
        QPost post = QPost.post;
        JPQLQuery<Post> query = from(post); // select p from Post p
        query.where(
                post.title.containsIgnoreCase(keyword)
                .or(post.content.containsIgnoreCase(keyword))
        ); // where p.title like ? or p.content like ?
        query.orderBy(post.id.desc()); // order by p.id desc
        
        return query.fetch();
    }

}
