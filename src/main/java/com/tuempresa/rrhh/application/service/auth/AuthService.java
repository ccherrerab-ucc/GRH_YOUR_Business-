/*package com.tuempresa.rrhh.infrastructure.controller.auth;

import com.tuempresa.rrhh.application.dto.auth.LoginRequest;
import com.tuempresa.rrhh.infrastructure.controller.auth.*;
import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.core.repository.UserRepository;
import com.tuempresa.rrhh.application.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        if (user.isAccountLocked()) {
            throw new LockedException("locked account.Change password.");
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            userService.increaseFailedAttempts(user);
            throw new BadCredentialsException("Bad credentials");
        }

        userService.resetFailedAttempts(user.getEmail());
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).message("Access Allowed").build();
    }

}*/