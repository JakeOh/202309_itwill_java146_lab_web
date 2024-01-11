package com.itwill.springboot3.domain;

import java.time.LocalDate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity @Table(name = "employees")
public class Employee {
    
    @Id
    @Column(name = "employee_id")
    private Integer id;
    
    @Embedded
    private EmployeeName name;
    
    @Basic(optional = false)
    private String email;
    
    private String phoneNumber;
    
    @Basic(optional = false)
    private LocalDate hireDate;
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId", nullable = false)
    private Job job;
    
    private Double salary;
    private Double commissionPct;
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}
