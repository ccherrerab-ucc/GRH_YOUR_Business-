package com.tuempresa.rrhh.infrastructure.controller;

import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.infrastructure.dto.UserDTO;
import com.tuempresa.rrhh.application.usecase.user.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
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

    // Métodos adicionales para obtener, actualizar y eliminar usuarios
}
