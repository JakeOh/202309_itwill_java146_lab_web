package com.itwill.spring2.repository;

import com.itwill.spring2.domain.User;
import com.itwill.spring2.dto.user.UserSignInDto;

public interface UserDao {
    
    User selectByUserid(String userid);
    int insert(User user);
    User selectByUseridAndPassword(UserSignInDto user);

}
