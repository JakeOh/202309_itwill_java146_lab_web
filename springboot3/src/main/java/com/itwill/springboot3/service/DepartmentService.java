package com.itwill.springboot3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.domain.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {
    
    private final DepartmentRepository deptDao;
    
    public Page<Department> getDeptList(int pageNo, Sort sort) {
        log.info("getDeptList(pageNo={}, sort={})", pageNo, sort);
        Pageable pageable = PageRequest.of(pageNo, 10, sort);
        
        return deptDao.findAll(pageable);
    }
    
    public Department getDeptDetails(Integer id) {
        log.info("getDeptDetails(id={})", id);
        
        return deptDao.findById(id).orElse(null);
    }

}
