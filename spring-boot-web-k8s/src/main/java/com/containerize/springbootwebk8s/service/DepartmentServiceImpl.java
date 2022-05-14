package com.containerize.springbootwebk8s.service;

import com.containerize.springbootwebk8s.entity.DepartmentEntity;
import com.containerize.springbootwebk8s.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<DepartmentEntity> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity updateDepartment(DepartmentEntity department, Long departmentId) {

        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId)
                .get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            departmentEntity.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            departmentEntity.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            departmentEntity.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(departmentEntity);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
