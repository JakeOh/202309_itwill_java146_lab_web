package com.itwill.jsp2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.domain.User;
import com.itwill.jsp2.dto.UserSignInDto;
import com.itwill.jsp2.dto.UserSignUpDto;
import com.itwill.jsp2.repository.UserDao;

public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    
    private final UserDao userDao = UserDao.getInstance();
    
    private static UserService instance = null;
    
    private UserService() {}
    
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        
        return instance;
    }
    
    // USERS 테이블에 회원 가입(insert) 성공하면 true, 실패하면 false를 리턴.
    public boolean signUp(UserSignUpDto dto) {
        log.debug("signUp(dto={})", dto);
        
        int result = userDao.insert(dto.toUser());
        
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    // userid와 password가 일치하면 null이 아닌 User 객체, 그렇지 않으면 null을 리턴.
    public User signIn(UserSignInDto dto) {
        log.debug("signIn(dto={})", dto);
        
        User user = userDao.selectByUseridAndPassword(dto);
        
        return user;
    }

}
