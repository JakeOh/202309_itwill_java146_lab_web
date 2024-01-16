package com.itwill.springboot4.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CommentRepositoryTest {
    
    @Autowired private CommentRepository commentDao;
    @Autowired private PostRepository postDao;
    
//    @Test
    public void testSave() {
        Post post = postDao.findById(310L).orElseThrow();
        Comment entity = Comment.builder()
                .post(post)
                .text("comment insert 테스트 2")
                .writer("admin")
                .build();
        log.info("save 전: {}, {}", entity, entity.getCreatedTime());
        
        commentDao.save(entity);
        
        log.info("save 후: {}, {}", entity, entity.getCreatedTime());
    }

    @Test
    public void testReadByPostId() {
        Sort sort = Sort.by("id").descending(); // id(PK) 컬럼 내림차순 정렬
        List<Comment> list = commentDao.findByPostId(310L, sort);
        
        list.forEach((x) -> log.info(x.toString()));
    }
    
}
