package com.itwill.springboot4.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // select m, r.roles 
    // from Member m 
    // left join Member_Roles r on m.id = r.member_id 
    // where m.username = ?
    @EntityGraph(attributePaths = "roles")
    Optional<Member> findByUsername(String username);
    
}
