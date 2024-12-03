package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.infrastructure.persintence.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}
