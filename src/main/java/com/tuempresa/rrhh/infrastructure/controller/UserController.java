package com.tuempresa.rrhh.infrastructure.controller;

import com.tuempresa.rrhh.core.domain.CreateUserCommand;
import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.application.dto.UserDTO;
import com.tuempresa.rrhh.core.usecase.CreateUserUseCase;
import com.tuempresa.rrhh.infrastructure.entity.UserEntity;
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
    public UserEntity createUser(@RequestBody UserDTO userDTO) {
        User user = new User(null, userDTO.getEmail(), userDTO.getPassword(), userDTO.getStatus(), userDTO.getCompany().getId(), userDTO.getPermissionRole().getId());
        CreateUserCommand command = new CreateUserCommand(
                user.getEmail(),
                user.getPassword(),
                user.getCompany(),
                user.getPermissionRole());
        return createUserUseCase.createUser(command);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = createUserUseCase.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Métodos adicionales para obtener, actualizar y eliminar usuarios
}
