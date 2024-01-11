package com.itwill.springboot3.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
@Embeddable
public class EmployeeName {
    private String firstName;
    
    @Basic(optional = false)
    private String lastName;
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
