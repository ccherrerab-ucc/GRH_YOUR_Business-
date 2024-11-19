package com.tuempresa.rrhh.core.domain;
import com.tuempresa.rrhh.infrastructure.entity.CompanyE;
import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserCommand {
    private String email;
    private String password;

    private CompanyE company;
    private PermissionRoleE permissionRole;
}
