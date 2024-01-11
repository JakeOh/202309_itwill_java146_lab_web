package com.itwill.springboot3.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ServiceTest {
    
    @Autowired private EmployeeService empSvc;
    
    @Test
    public void test() {
        Page<Employee> page = empSvc.getEmpList(0, Sort.by("id"));
        log.info("no.={}, size={}, total={}, hasPrev={}, hasNext={}", 
                page.getNumber(), page.getSize(), page.getTotalElements(),
                page.hasPrevious(), page.hasNext());
        
    }

}
