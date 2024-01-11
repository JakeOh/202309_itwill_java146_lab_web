package com.itwill.springboot3;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.domain.DepartmentRepository;
import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.domain.EmployeeRepository;
import com.itwill.springboot3.domain.JobRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryTest {

    @Autowired private EmployeeRepository empDao;
    @Autowired private DepartmentRepository deptDao;
    @Autowired private JobRepository jobDao;
    
    @Transactional // FetchType.LAZY의 실행 결과를 JUnit 테스트에서 확인하기 위해서.
    @Test 
    @Order(1)
    public void testEmpDao() {
        long count = empDao.count();
        Assertions.assertEquals(107, count);
        
        List<Employee> employees = empDao.findAll();
        Employee emp = employees.get(0);
        log.info(emp.toString());
        
        //<--- 여기서부터의 로그는 @Transactional 애너테이션이 있어야 확인할 수 있음.
        log.info(emp.getJob().toString());
        log.info(emp.getDepartment().toString());
        log.info(emp.getDepartment().getManager().toString());
        log.info(emp.getDepartment().getLocation().toString());
        log.info(emp.getDepartment().getLocation().getCountry().toString());
        log.info(emp.getDepartment().getLocation().getCountry().getRegion().toString());
        //--->
    }
    
    @Transactional
    @Test
    @Order(2)
    public void testDeptDao() {
        Department dept10 = deptDao.findById(10).orElseThrow();
        log.info("dept #10: {}", dept10);
        log.info("dept #10 mgr: {}", dept10.getManager());
        
        Department dept200 = deptDao.findById(200).orElseThrow();
        log.info("dept #200: {}", dept200);
        log.info("dept #200 mgr: {}", dept200.getManager());
        
    }
    
}
