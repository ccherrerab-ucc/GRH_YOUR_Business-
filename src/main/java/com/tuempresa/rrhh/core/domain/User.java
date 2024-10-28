package com.tuempresa.rrhh.core.domain;

public class User {
    private Integer id;
    private String email;
    private String password;
    private Integer status;

    // Constructor, getters y setters
    public User() {}

    public User(Integer id, String email, String password, Integer status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}