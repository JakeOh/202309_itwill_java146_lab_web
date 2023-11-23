package com.itwill.jsp2.domain;

public class User {
    private Long id;
    private String userid;
    private String password;
    private String email;
    private Long points;
    
    public User() {}

    public User(Long id, String userid, String password, String email, Long points) {
        this.id = id;
        this.userid = userid;
        this.password = password;
        this.email = email;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userid=" + userid + ", password=" + password + ", email=" + email + ", points="
                + points + "]";
    }
    
    //----- Builder(Factory) pattern
    public static UserBuilder builder() {
        return new UserBuilder();
    }
    
    public static class UserBuilder {
        private Long id;
        private String userid;
        private String password;
        private String email;
        private Long points;
        
        private UserBuilder() {}
        
        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }
        
        public UserBuilder userid(String userid) {
            this.userid = userid;
            return this;
        }
        
        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }
        
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        public UserBuilder points(Long points) {
            this.points = points;
            return this;
        }
        
        public User build() {
            return new User(id, userid, password, email, points);
        }
    }
    
}
