package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Comment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
)
public class CommentDaoTest {
    
    // 리포지토리 객체를 주입받음(의존성 주입 DI, 제어의 역전 IoC)
    @Autowired private CommentDao commentDao;

//    @Test
    public void testSelectCommentCounts() {
        Long counts = commentDao.selectCommentCounts(1);
        log.debug("counts = {}", counts);
    }
    
//    @Test
    public void testUpdate() {
        Comment comment = Comment.builder()
                .id(7L).ctext("댓글 업데이터 unit test")
                .build();
        int result = commentDao.update(comment);
        Assertions.assertEquals(1, result);
    }
    
//    @Test
    public void testDeleteByPostId() {
        int result = commentDao.deleteByPostId(1);
        log.debug("result = {}", result);
    }
    
//    @Test
    public void testDeleteById() {
        int result = commentDao.deleteById(4);
        Assertions.assertEquals(1, result);
    }
    
//    @Test
    public void testInsert() {
        Comment comment = Comment.builder()
                .postid(1L)
                .writer("guest")
                .ctext("MyBatis-Spring 댓글 입력 3")
                .build();
        
        int result = commentDao.insert(comment);
        Assertions.assertEquals(1, result);
        
    }
    
    @Test
    public void testSelectByPostId() {
        Assertions.assertNotNull(commentDao);
        
        List<Comment> list = commentDao.selectByPostId(1);
        for (Comment c : list) {
            log.debug(c.toString());
        }
    }
    
}
