package com.itwill.springboot3.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    // JPA query method 작성 방법:
    
    // 부서 번호가 일치하는 모든 직원들의 정보를 검색
    // select * from employees where department_id = ?
    List<Employee> findByDepartmentId(Integer id);
    
    
}
