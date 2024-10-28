package com.tuempresa.rrhh.application.dto;

public class UserDTO {
    private String email;
    private String password;
    private Integer status;

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
}
