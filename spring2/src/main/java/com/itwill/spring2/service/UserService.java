package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.User;
import com.itwill.spring2.dto.user.UserRegisterDto;
import com.itwill.spring2.repository.UserDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserDao userDao;
    
    public boolean checkUserid(String userid) {
        log.debug("checkUserid(userid={})", userid);
        
        User user = userDao.selectByUserid(userid);
        if (user == null) { // USERS 테이블에 userid가 없는 경우 -> 회원가입에서 사용가능한 아이디 
            return true;
        } else { // USERS 테이블에 userid가 이미 있는 경우 -> 회원가입에서 사용 불가능한 아이디
            return false;
        }
    }
    
    public int create(UserRegisterDto dto) {
        log.debug("create(dto={})", dto);
        
        int result = userDao.insert(dto.toEntity());
        log.debug("회원가입 결과 = {}", result);
        
        return result;
    }

}
