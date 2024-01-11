package com.itwill.springboot3.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    
    private String streetAddress;
    private String postalCode;
    
    @Basic(optional = false)
    private String city;
    
    private String stateProvince;

}
