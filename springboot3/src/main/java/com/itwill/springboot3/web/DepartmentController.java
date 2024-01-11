package com.itwill.springboot3.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller 
@RequestMapping("/department")
public class DepartmentController {
    
    private final DepartmentService deptSvc;
    
    @GetMapping("/list")
    public void getDeptList(@RequestParam(name = "p", defaultValue = "0") int pageNo,
            Model model) {
        log.info("getDeptList(pageNo={})", pageNo);
        
        Page<Department> page = deptSvc.getDeptList(pageNo, Sort.by("id"));
        model.addAttribute("page", page);
    }
    
    @GetMapping("/details/{id}")
    public String getDeptDetails(@PathVariable(name = "id") Integer id, Model model) {
        log.info("getDeptDetails(id={})", id);
        
        Department dept = deptSvc.getDeptDetails(id);
        model.addAttribute("department", dept);
        
        return "department/details";
    }

}
