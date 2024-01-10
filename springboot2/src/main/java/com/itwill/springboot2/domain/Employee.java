package com.itwill.springboot2.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMP")
public class Employee {
    
    @Id
    @Column(name = "EMPNO")
    private Integer id;
    
    private String ename;
    
    private String job;
    
    @Column(name = "MGR")
    private Integer manager;
    
    private LocalDate hiredate;
    
    @Column(name = "SAL")
    private Double salary;
    
    @Column(name = "COMM")
    private Double commission;
    
    private Integer deptno;

}
