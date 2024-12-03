package com.tuempresa.rrhh.core.repository.personal_data;


import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.domain.Department;

import java.util.Optional;

public interface DepartmentRepository {
    Optional<Department> findById(Integer id);
    Department save(Department department);
}
