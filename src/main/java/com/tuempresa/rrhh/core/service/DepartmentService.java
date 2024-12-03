package com.tuempresa.rrhh.core.service;

import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.domain.Department;
import com.tuempresa.rrhh.core.domain.Position;
import com.tuempresa.rrhh.core.repository.personal_data.DepartmentRepository;
import com.tuempresa.rrhh.infrastructure.persintence.entity.DepartmentEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Área no encontrada"));
    }

}
