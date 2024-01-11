package com.itwill.springboot3.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity @Table(name = "jobs")
public class Job {
    
    @Id
    @Column(name = "job_id")
    private String id;
    
    @Basic(optional = false)
    private String jobTitle;
    
    private Integer minSalary;
    private Integer maxSalary;

}
