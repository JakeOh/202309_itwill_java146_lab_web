package com.itwill.springboot2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService deptSvc;
    
    @GetMapping("/list")
    public void deptList(Model model) {
        log.info("deptList()");
        
        List<Department> departments = deptSvc.getDepartmentList();
        model.addAttribute("departments", departments);
    }
    
    @GetMapping("/details/{id}")
    public String deptDetails(@PathVariable(name = "id") Integer id, Model model) {
        log.info("deptDetails(id={})", id);
        
        Department dept = deptSvc.getDepartmentDetails(id);
        model.addAttribute("department", dept);
//        log.info("# of employees = {}", dept.getEmployees().size());
        
        return "department/details";
    }
    
}
