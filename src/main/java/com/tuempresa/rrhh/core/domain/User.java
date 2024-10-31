package com.tuempresa.rrhh.core.domain;

import com.tuempresa.rrhh.core.domain.domain_user.Company;
import com.tuempresa.rrhh.core.domain.domain_user.PermissionRole;

public class User {
    private Integer id;
    private String email;
    private String password;
    private Integer status;
    private Company company;
    private PermissionRole permissionRole;

    // Constructor, getters y setters
    public User(Integer id, String email, String password, Integer status, Integer company, Integer role) {}

    public User(Integer id, String email, String password, Integer status, Company company, PermissionRole permissionRole) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = status;
        this.company = company;
        this.permissionRole = permissionRole;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    public PermissionRole getPermissionRole() { return permissionRole; }
    public void setPermissionRole(PermissionRole permissionRole) { this.permissionRole = permissionRole; }
}