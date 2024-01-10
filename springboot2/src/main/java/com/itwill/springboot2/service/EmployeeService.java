package com.itwill.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot2.domain.Employee;
import com.itwill.springboot2.domain.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {
    
    private final EmployeeRepository empDao;
    
    public List<Employee> getEmployeeList() {
        log.info("getEmployeeList()");
        
        return empDao.findAll();
    }

}
