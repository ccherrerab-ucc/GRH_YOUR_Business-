package com.tuempresa.rrhh.application.dto;

import com.tuempresa.rrhh.core.domain.domain_user.Company;
import com.tuempresa.rrhh.core.domain.domain_user.PermissionRole;

public class UserDTO {
    private String email;
    private String password;
    private Integer status;
    private Integer company;
    private Integer permissionRole;


    // Constructor, getters y setters
    public UserDTO() {}

    public UserDTO(String email, String password, Integer status) {
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Integer getCompany() { return company; }
    public void setCompany(Integer company) { this.company = company; }

    public Integer getPermissionRole() { return permissionRole; }
    public void setPermissionRole(Integer permissionRole) { this.permissionRole = permissionRole; }
}
