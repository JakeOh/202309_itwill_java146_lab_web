package com.itwill.springboot3.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.domain.EmployeeName;
import com.itwill.springboot3.domain.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JpaExampleTest {
    
    @Autowired private EmployeeRepository empDao;
    
//    @Test 
    public void test() {
        // lastName이 King인 직원(들)의 정보 검색
        Employee emp = new Employee();
        EmployeeName name = new EmployeeName();
        name.setLastName("King");
        emp.setName(name);
        Example<Employee> example = Example.of(emp);
        
        List<Employee> list = empDao.findAll(example);
        list.forEach((e) -> log.info(e.toString()));
    }
    
    @Test
    public void test2() {
        // 부서 이름이 "IT"인 직원들의 정보를 Exmaple을 사용해서 검색
        Department dept = new Department();
        dept.setDepartmentName("IT");
        
        Employee emp = new Employee();
        emp.setDepartment(dept);
        
        Example<Employee> example = Example.of(emp);
        Pageable pageable = PageRequest.of(1, 3, Sort.by("id"));
        
        Page<Employee> list = empDao.findAll(example, pageable);
        list.forEach((e) -> log.info(e.toString()));
        log.info("number={}, # of elements={}, # of total = {}", 
                list.getNumber(), 
                list.getNumberOfElements(),
                list.getTotalElements());
    }
    
    // 특정 도시에서 근무하는 직원들
    // 특정 나라에서 근무하는 직원들

}
