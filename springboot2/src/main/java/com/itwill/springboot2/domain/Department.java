package com.itwill.springboot2.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

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
    
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employees;

}
