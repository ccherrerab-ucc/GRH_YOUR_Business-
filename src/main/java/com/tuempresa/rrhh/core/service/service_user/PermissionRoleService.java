package com.tuempresa.rrhh.core.service.service_user;

import com.tuempresa.rrhh.core.domain.domain_user.PermissionRole;
import com.tuempresa.rrhh.core.repository.repository_user.PermissionRoleRepository;
import com.tuempresa.rrhh.infrastructure.persintence.entity.PermissionRoleE;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionRoleService {
    private final PermissionRoleRepository permissionRoleRepository;

    public PermissionRole getPermissionRoleById(Integer id) { //dominio
        PermissionRoleE entity = permissionRoleRepository.findById(id) //entity
                .orElseThrow(() -> new RuntimeException("PermissionRole not found"));
        return new PermissionRole(entity.getId(), entity.getNameRole());
    }
}


