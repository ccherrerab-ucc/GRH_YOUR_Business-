package com.tuempresa.rrhh.core.repository.repository_user;

import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRoleRepository  extends JpaRepository<PermissionRoleE, Integer> {
    Optional<PermissionRoleE> findByName(String roleName);


}