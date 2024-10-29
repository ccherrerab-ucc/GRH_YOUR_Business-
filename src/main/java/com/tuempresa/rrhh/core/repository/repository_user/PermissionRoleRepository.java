package com.tuempresa.rrhh.core.repository.repository_user;

import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRoleRepository extends JpaRepository<PermissionRoleE, Integer> {

}