package com.containerize.springbootwebk8s.controller;

import com.containerize.springbootwebk8s.entity.DepartmentEntity;
import com.containerize.springbootwebk8s.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentRestController {

    private final DepartmentService departmentService;

    @PostMapping("/ping-department")
    public String saveDepartment() {
        return "Ping from Department";
    }

    @PostMapping("/departments")
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<DepartmentEntity> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{departmentId}")
    public DepartmentEntity updateDepartment(@RequestBody DepartmentEntity department, @PathVariable("departmentId") Long departmentId) {
        return departmentService.updateDepartment(department, departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }
}
