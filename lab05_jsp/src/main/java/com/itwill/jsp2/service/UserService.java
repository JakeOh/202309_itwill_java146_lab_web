package com.itwill.jsp2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    
    public boolean signUp(UserSignUpDto dto) {
        log.debug("signUp(dto={})", dto);
        
        int result = userDao.insert(dto.toUser());
        
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

}
