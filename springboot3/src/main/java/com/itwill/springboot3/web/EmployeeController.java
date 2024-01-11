package com.itwill.springboot3.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot3.domain.Employee;
import com.itwill.springboot3.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    private final EmployeeService empSvc;
    
    @GetMapping("/list")
    public void empList(@RequestParam(name = "p", defaultValue = "0") int pageNo, 
            Model model) {
        log.info("empList(pageNo={})", pageNo);
        
        Page<Employee> page = empSvc.getEmpList(pageNo, Sort.by("id"));
        model.addAttribute("page", page);
    }
    
    @GetMapping("/details/{id}")
    public String empDetails(@PathVariable(name = "id") Integer id, Model model) {
        log.info("empDetails(id={})", id);
        
        Employee emp = empSvc.getEmpDetails(id);
        model.addAttribute("employee", emp);
        
        return "employee/details";
    }

}
