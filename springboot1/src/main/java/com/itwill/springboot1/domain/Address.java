package com.itwill.springboot1.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable // 엔터티 클래스의 필드로 포함될 수 있는 객체.
public class Address {
    
    private int postalCode;
    private String country;
    private String city;
    private String district;
    private String street;
    private int streetNo;

}
