package com.itwill.spring1.dto;

import lombok.Data;

@Data
// @Data = @ToString + @EqualsAndHashCode + @Getter + @Setter + @RequiredArgsConstructor
// @NoArgsConstructor: 아규먼트를 갖지 않는 생성자. 기본 생성자.
// @AllArgsConstructor: 모든 필드들을 아규먼트로 갖는 생성자.
// @RequiredArgsConstructor: final 필드들만 아규먼트로 갖는 생성자.
public class ExampleDto {
    // 요청 파라미터 이름과 같게 필드 이름을 선언.
    private String username;
    private int age;

}
