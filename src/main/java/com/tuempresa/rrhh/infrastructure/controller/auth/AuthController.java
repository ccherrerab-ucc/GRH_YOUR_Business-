package com.tuempresa.rrhh.infrastructure.controller.auth;

import com.tuempresa.rrhh.application.dto.auth.AuthResponse;
import com.tuempresa.rrhh.application.dto.auth.LoginRequest;
import com.tuempresa.rrhh.core.domain.auth.AuthRequest;
import com.tuempresa.rrhh.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
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
    @PostMapping(value = "loginpr")

    public String login() {
        return "login from public endpoint";
    }

    @PostMapping(value = "logina")
    public String register() {
        return "register from public endpoint";
    }/*
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
