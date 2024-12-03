package com.tuempresa.rrhh.infrastructure.persintence.repository;

import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.domain.Department;
import com.tuempresa.rrhh.core.repository.personal_data.DepartmentRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.AreaMapper;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.DepartmentMapper;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.JpaDepartmentRepository;
import com.tuempresa.rrhh.infrastructure.persintence.entity.AreaEntity;
import com.tuempresa.rrhh.infrastructure.persintence.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DeparmentRepositoryImpl implements DepartmentRepository {

    private final JpaDepartmentRepository jpaDepartmentRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DeparmentRepositoryImpl(JpaDepartmentRepository jpaDepartmentRepository, DepartmentMapper departmentMapper) {
        this.jpaDepartmentRepository = jpaDepartmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return jpaDepartmentRepository.findById(id).map(departmentMapper::toDomain);
    }

    @Override
    public Department save(Department department) {
        DepartmentEntity departmentEntity = departmentMapper.toEntity(department);
        return departmentMapper.toDomain(jpaDepartmentRepository.save(departmentEntity));
    }
}
