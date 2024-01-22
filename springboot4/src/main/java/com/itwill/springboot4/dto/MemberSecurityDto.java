package com.itwill.springboot4.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.itwill.springboot4.domain.Member;

// (1) UserDetails 인터페이스를 직접 구현하거나
// (2) UserDetials 인터페이스를 구현하는 User 클래스를 상속
public class MemberSecurityDto extends User {

    private String email;
    
    private MemberSecurityDto(String username, String password, String email,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        //-> 상위 클래스 User는 기본 생성자를 갖고 있지 않기 때문에, 명시적으로 생성자를 호출.
        
        this.email = email;
    }
    
    public static MemberSecurityDto fromEntity(Member entity) {
        List<SimpleGrantedAuthority> authorities =
                entity.getRoles().stream()
                .map((x) -> new SimpleGrantedAuthority(x.toString()))
                .toList();
        
        return new MemberSecurityDto(entity.getUsername(), entity.getPassword(), 
                entity.getEmail(), authorities);
    }

}
