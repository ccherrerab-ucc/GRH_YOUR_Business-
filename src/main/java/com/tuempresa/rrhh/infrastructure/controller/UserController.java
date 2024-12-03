package com.tuempresa.rrhh.infrastructure.controller;

import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.infrastructure.dto.UserDTO;
import com.tuempresa.rrhh.application.usecase.user.CreateUserUseCase;
import com.tuempresa.rrhh.infrastructure.persintence.entity.EmployeeE;
import com.tuempresa.rrhh.infrastructure.persintence.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final EmployeeRepository employeeRepository;


    public UserController(CreateUserUseCase createUserUseCase, EmployeeRepository employeeRepository) {
        this.createUserUseCase = createUserUseCase;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO) {
        User user = new User(null, userDTO.getEmail(), userDTO.getPassword(), userDTO.getStatus(), userDTO.getCompany(), userDTO.getPermissionRole());
        return createUserUseCase.createUser(user);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = createUserUseCase.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "employees")
    public ResponseEntity<List<EmployeeE>> getAllEmployees() {
        List<EmployeeE> users = employeeRepository.findAll();
        return ResponseEntity.ok(users);
    }

    // Métodos adicionales para obtener, actualizar y eliminar usuarios
}
