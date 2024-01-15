package com.itwill.springboot4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.EntityListeners;

/*
 * insert/update 쿼리를 실행할 때 시간을 자동으로 저장:
 * 엔터티의 생성/최종수정 시간을 자동으로 기록하기 위해서 JPA auditing 기능을 활성화시킴.
 * (1) main 클래스에서 @EnableJpaAuditing 애너테이션을 사용.
 * (2) 날짜/시간(LocalDate, LocalDateTime) 필드를 갖는 엔터티에
 * @EntityListeners(AuditingEntityListener.class) 애너테이션을 사용.
 * (3) 날짜/시간 필드에 @CreatedDate, @LastModifiedDate 애너테이션을 사용.
 */

@EnableJpaAuditing //-> JPA Auditing 기능 활성화.
//-> AuditingEntityListener를 사용할 수 있게 함. -> 엔터티 생성/수정 시간 자동 기록.
@SpringBootApplication
public class Springboot4Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot4Application.class, args);
	}

}
