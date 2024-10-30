package com.tuempresa.rrhh.infrastructure.controller.auth;

import com.tuempresa.rrhh.application.dto.auth.AuthResponse;
import com.tuempresa.rrhh.application.dto.auth.LoginRequest;
import com.tuempresa.rrhh.application.dto.auth.RegisterRequest;
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

    /*
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return handleLogin(request);
    }

    private ResponseEntity<AuthResponse> handleLogin(LoginRequest request) {
        try {
            return ResponseEntity.ok(authService.login(request));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(AuthResponse.builder().message("Invalid credentials provided").build());
        } catch (LockedException e) {
            return ResponseEntity.status(423).body(AuthResponse.builder().message("Account is locked. Please contact support.").build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(AuthResponse.builder().message("Internal server error").build());
        }
    }*/
}
