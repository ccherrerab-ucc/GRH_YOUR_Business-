package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.core.domain.Department;
import com.tuempresa.rrhh.infrastructure.persintence.entity.DepartmentEntity;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentEntity toEntity(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(department.getId());
        departmentEntity.setName_department(department.getName());
        return departmentEntity;
    }

    public Department toDomain(DepartmentEntity departmentEntity) {
        Department department = new Department();
        department.setId(departmentEntity.getId());
        department.setName(departmentEntity.getName_department());
        return department;
    }
}
