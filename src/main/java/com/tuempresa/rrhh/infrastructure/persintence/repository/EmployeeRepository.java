package com.tuempresa.rrhh.infrastructure.persintence.repository;

import com.tuempresa.rrhh.infrastructure.persintence.entity.EmployeeE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmployeeRepository extends JpaRepository<EmployeeE, Integer> {


}