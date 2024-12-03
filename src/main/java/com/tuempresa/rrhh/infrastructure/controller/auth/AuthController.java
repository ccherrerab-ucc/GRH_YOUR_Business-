package com.tuempresa.rrhh.infrastructure.controller.auth;

import com.tuempresa.rrhh.infrastructure.dto.auth.AuthResponse;
import com.tuempresa.rrhh.infrastructure.dto.auth.LoginRequest;
import com.tuempresa.rrhh.infrastructure.dto.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tuempresa.rrhh.application.service.auth.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

}
