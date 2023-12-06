package com.itwill.spring2.repository;

import com.itwill.spring2.domain.User;

public interface UserDao {
    
    User selectByUserid(String userid);
    int insert(User user);

}
