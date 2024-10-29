package com.tuempresa.rrhh.application.service.service_user;

import com.tuempresa.rrhh.core.domain.domain_user.Company;
import com.tuempresa.rrhh.core.domain.domain_user.PermissionRole;
import com.tuempresa.rrhh.core.repository.repository_user.CompanyRepository;
import com.tuempresa.rrhh.core.repository.repository_user.PermissionRoleRepository;
import com.tuempresa.rrhh.infrastructure.entity.CompanyE;
import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company getCompanyById(Integer id) { //dominio
        CompanyE entity = companyRepository.findById(id) //entity
                .orElseThrow(() -> new RuntimeException("PermissionRole not found"));
        return new Company(entity.getId(), entity.getNameCompany());
    }
}


