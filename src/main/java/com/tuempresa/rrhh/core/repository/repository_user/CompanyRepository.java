package com.tuempresa.rrhh.core.repository.repository_user;

import com.tuempresa.rrhh.infrastructure.entity.CompanyE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyE, Integer> {

}