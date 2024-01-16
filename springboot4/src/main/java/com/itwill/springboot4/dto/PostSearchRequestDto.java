package com.itwill.springboot4.dto;

import lombok.Data;

@Data
public class PostSearchRequestDto {
    
    private String category; // 검색 카테고리(t, c, tc, a)
    private String keyword; // 검색 키워드
    private int p; // 검색 결과의 페이지 번호(0부터 시작)

}
