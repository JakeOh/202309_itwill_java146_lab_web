package com.itwill.jsp2.dto;

import com.itwill.jsp2.domain.User;

public class UserSignUpDto {
    private String userid;
    private String password;
    private String email;

    public UserSignUpDto() {}

    public UserSignUpDto(String userid, String password, String email) {
        this.userid = userid;
        this.password = password;
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserSignUpDto [userid=" + userid + ", password=" + password + ", email=" + email + "]";
    }
    
    public User toUser() {
        return User.builder()
                .userid(userid).password(password).email(email)
                .build();
    }
    
    //----- builder pattern
    public static UserSignUpDtoBuilder builder() {
        return new UserSignUpDtoBuilder();
    }
    
    public static class UserSignUpDtoBuilder {
        private String userid;
        private String password;
        private String email;
        
        private UserSignUpDtoBuilder() {}
        
        public UserSignUpDtoBuilder userid(String userid) {
            this.userid = userid;
            return this;
        }
        
        public UserSignUpDtoBuilder password(String password) {
            this.password = password;
            return this;
        }
        
        public UserSignUpDtoBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        public UserSignUpDto build() {
            return new UserSignUpDto(userid, password, email);
        }
    }
    
}
