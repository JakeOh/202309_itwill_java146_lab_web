package com.itwill.springboot2.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {
    
    @Autowired
    private EmployeeRepository empDao;
    
    @Test
    public void test() {
        List<Employee> list = empDao.findAll();
        for (Employee e : list) {
            log.info(e.toString());
        }
    }

}
