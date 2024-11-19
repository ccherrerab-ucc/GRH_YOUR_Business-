/*package com.tuempresa.rrhh.infrastructure.repository;

import com.tuempresa.rrhh.core.repository.repository_user.PermissionRoleRepository;
import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepositoryImpl implements PermissionRoleRepository {

    private final PermissionRoleJpaRepository jpaRepository;

    public RoleRepositoryImpl(PermissionRoleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    @Override
    public Optional<PermissionRoleE> findByName(String roleName) {
        // Suponiendo que tienes una entidad Role que tiene un campo 'name'
        return jpaRepository.findByName(roleName);
    }

}*/
