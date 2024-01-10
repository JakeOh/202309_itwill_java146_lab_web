package com.itwill.springboot2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DEPT")
public class Department {
    
    @Id
    @Column(name = "deptno")
    private Integer id;
    
    private String dname;
    
    @Column(name = "loc")
    private String location;

}
