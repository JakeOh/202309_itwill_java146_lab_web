package com.itwill.spring2.repository;

import java.util.List;

import com.itwill.spring2.domain.Comment;

public interface CommentDao {

    List<Comment> selectByPostId(long postid);
    int insert(Comment comment);
    int deleteById(long id);
    int deleteByPostId(long postid);
    int update(Comment comment);
    Long selectCommentCounts(long postid);
    
}
