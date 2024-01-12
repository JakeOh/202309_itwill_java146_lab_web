package com.itwill.springboot3.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    
    // 입사날짜(hireDate)가 특정 날짜 이후인 직원들의 정보(where hire_date > ?)
    List<Employee> findByHireDateAfter(LocalDate date);
    
    // 입사날짜가 특정 날짜 이전인 직원들의 정보(where hire_date < ?)
    List<Employee> findByHireDateBefore(LocalDate date);
    
    // 입사날짜가 날짜 범위에 포함되는 직원들의 정보(where hire_date between ? and ?)
    List<Employee> findByHireDateBetween(LocalDate start, LocalDate end);
    
    // 매니저가 null인 직원들의 정보(where manager_id is null)
    List<Employee> findByManagerIdNull(); // findByManagerIdIsNull()
    
    
    // JPQL(Java Persistence Query Language):
    // JPA에서 사용하는 "객체지향" 쿼리.
    // 테이블 이름과 테이블 컬럼으로 SQL을 작성하는 것이 아니라, 
    // 엔터티 객체의 이름과 엔터티 필드 이름으로 쿼리를 작성하는 문법.
    // alias(별명)을 반드시 사용해야 함.
    // 엔터티 이름과 엔터티 필드 이름들은 대소문자를 구분함!
    
    // firstName과 lastName이 일치하는 직원들의 정보
//    @Query("select e from Employee e where e.name.firstName = ?1 and e.name.lastName = ?2")
//    List<Employee> findByName(String firstName, String lastName);
    
    @Query("select e from Employee e " +
            "where e.name.firstName = :first and e.name.lastName = :last")
    List<Employee> findByName(@Param("first") String firstName, 
            @Param("last") String lastName);
    
    // firstName 또는 lastName에 특정 문자열을 포함하는 직원들의 정보. 대/소문자 구분 없이.
    @Query ("select e from Employee e "
            + "where upper(e.name.firstName) like upper('%' || :keyword || '%') "
            + "or upper(e.name.lastName) like upper('%' || :keyword || '%')")
    List<Employee> findByNameContaining(@Param("keyword") String keyword);
    
}
