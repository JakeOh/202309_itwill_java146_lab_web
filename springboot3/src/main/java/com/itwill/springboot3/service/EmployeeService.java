package com.itwill.springboot3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.domain.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {
    
    private final EmployeeRepository empDao;
    
    public Page<Employee> getEmpList(int pageNo, Sort sort) {
        log.info("getEmpList(pageNo={}, sort={})", pageNo, sort);
        
        Pageable pageable = PageRequest.of(pageNo, 10, sort);
        Page<Employee> page = empDao.findAll(pageable);
        
        return page;
    }
    
    public Employee getEmpDetails(Integer id) {
        log.info("getEmpDetails(id={})", id);
        
        return empDao.findById(id).orElse(null);
    }

}
