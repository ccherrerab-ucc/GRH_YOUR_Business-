package com.tuempresa.rrhh.infrastructure.repository;

import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRoleJpaRepository extends JpaRepository<PermissionRoleE, Long> {

    Optional<PermissionRoleE> findByName(String roleName);

    // Otros métodos CRUD si son necesarios
}