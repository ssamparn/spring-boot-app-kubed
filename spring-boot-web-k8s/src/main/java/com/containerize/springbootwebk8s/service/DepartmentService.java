package com.containerize.springbootwebk8s.service;

import com.containerize.springbootwebk8s.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    DepartmentEntity saveDepartment(DepartmentEntity department);
    List<DepartmentEntity> fetchDepartmentList();
    DepartmentEntity updateDepartment(DepartmentEntity department, Long departmentId);
    void deleteDepartmentById(Long departmentId);
}
