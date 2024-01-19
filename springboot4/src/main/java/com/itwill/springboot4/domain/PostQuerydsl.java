package com.itwill.springboot4.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/*
 * Querydsl 라이브러리:
 * 1. build.gradle에 의존성(dependency)을 추가, 빌드 옵션 설정.
 *    -> gradle tasks -> build 실행 -> refresh gradle project
 *    -> build/generated/querydsl/패키지 아래에 QDomain 클래스들이 생성.
 * 2. 인터페이스 작성 - PostQuerydsl
 *    - Querydsl 라이브러리를 사용할 메서드 선언
 * 3. 인터페이스를 구현하는 클래스를 작성 - PostQuerydslImpl
 *    - QuerydslRepositorySupport 클래스를 상속하고, 인터페이스도 구현.
 *    - QuerydslRepositorySupport 클래스는 기본 생성자가 없기 때문에, 반드시 
 *    아규먼트를 갖는 생성자를 명시적으로 호출해야 함.
 *    - 인터페이스에서 선언된 메서드들을 구현.
 * 4. JpaRepository를 상속하는 리포지토리 인터페이스(PostRepository)에서
 *    PostQuerydsl 인터페이스를 상속 -> 의존성 주입을 받아서 Querydsl을 사용할 수 있게 됨.
 */

public interface PostQuerydsl {
    
    Post searchById(Long id);
    List<Post> searchByTitleOrContent(String keyword);
    List<Post> searchByModifiedTime(LocalDateTime from, LocalDateTime to);
    List<Post> searchByKeywordAndAuthor(String keyword, String author);
    List<Post> searchByKeywords(String[] keywords);
    Page<Post> searchByKeywords(String[] keywords, Pageable pageable);
    
}
