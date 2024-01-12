package com.itwill.springboot3.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    // JPA query method 작성 방법:
    
    // 부서 번호가 일치하는 모든 직원들의 정보를 검색
    // select * from employees where department_id = ?
    List<Employee> findByDepartmentId(Integer id);
    
    // 부서 이름이 일치하는 (대소문자는 구분하지 않는) 모든 직원들의 정보를 검색
    List<Employee> findByDepartmentDepartmentNameIgnoreCase(String departmentName);
    
    // 성(lastName)이 일치하는 모든 직원들의 정보를 검색(where last_name = ?)
    List<Employee> findByNameLastName(String lastName);
    
    // lastName에 특정 문자열이 포함되는 직원들의 정보(where last_name like ?)
    List<Employee> findByNameLastNameContaining(String lastName);
    
    // lastName에 대소문자 구분없이 특정 문자열이 포함되는 직원들의 정보
    // where upper(last_name) like upper(?)
    List<Employee> findByNameLastNameContainingIgnoreCase(String lastName);
    
    // lastName에 대소문자 구분없이 특정 문자열이 포함되고, 정렬 순서는 lastName 오름차순
    // where upper(last_name) like upper(?) order by last_name
    List<Employee> findByNameLastNameContainingIgnoreCaseOrderByNameLastName(String lastName);
    
    // 급여(salary)가 어떤 값을 초과하는 직원들의 정보(where salary > ?)
    List<Employee> findBySalaryGreaterThan(Double salary);
    
    // 급여가 어떤 값 미만인 직원들의 정보(where salary < ?)
    List<Employee> findBySalaryLessThan(Double salary);
    
    // 급여가 어떤 범위 안에 있는 직원들의 정보(where salary between ?1 and ?2)
    List<Employee> findBySalaryBetween(Double start, Double end);
    
}
