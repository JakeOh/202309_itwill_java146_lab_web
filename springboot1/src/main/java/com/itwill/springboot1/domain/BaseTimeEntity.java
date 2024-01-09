package com.itwill.springboot1.domain;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass // 엔터티 클래스의 상위 클래스로 사용될 클래스.
public class BaseTimeEntity {
    
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

}
