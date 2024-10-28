package com.tuempresa.rrhh.infrastructure.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private Integer status;

    // Constructor, getters y setters
    public UserEntity() {}

    public UserEntity(String email, String password, Integer status) {
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
