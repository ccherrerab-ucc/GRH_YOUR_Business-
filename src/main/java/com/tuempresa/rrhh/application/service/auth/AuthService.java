package com.tuempresa.rrhh.application.service.auth;

import com.tuempresa.rrhh.application.service.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.tuempresa.rrhh.application.dto.auth.AuthResponse;
import com.tuempresa.rrhh.application.dto.auth.LoginRequest;
import com.tuempresa.rrhh.application.dto.auth.RegisterRequest;
import com.tuempresa.rrhh.application.service.service_user.*;
import com.tuempresa.rrhh.core.domain.domain_user.Company;
import com.tuempresa.rrhh.core.domain.domain_user.PermissionRole;
import com.tuempresa.rrhh.core.repository.UserRepository;
import com.tuempresa.rrhh.infrastructure.entity.CompanyE;
import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import com.tuempresa.rrhh.infrastructure.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    //private final UserService userService;
    private final PermissionRoleService permissionRoleService;
    private final CompanyService companyService;


    public AuthResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));
        System.out.println(request.getPassword());
        System.out.println(request.getEmail());
        //System.out.println(request.getId());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        try {

        } catch (BadCredentialsException e) {
            //userService.increaseFailedAttempts(user);
            throw new BadCredentialsException("Bad credentials");
        }

        //userService.resetFailedAttempts(user.getEmail());
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).message("Access Allowed").build();
    }
    public AuthResponse logina(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();

    }

    public AuthResponse register(RegisterRequest request) {
        PermissionRole role = permissionRoleService.getPermissionRoleById(request.getRole());
        Company company = companyService.getCompanyById(request.getCompany());

        PermissionRoleE roleEntity = convertToEntity(role);
        CompanyE companyEntity = convertToEntity(company);


        String password = passwordEncoder.encode(request.getPassword());

        UserEntity user = UserEntity.builder()
                .email(request.getEmail())
                .password(password)
                .status(request.getStatus())
                .role(roleEntity)
                .company(companyEntity)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .message("User registered successfully")
                .build();
    }
    private PermissionRoleE convertToEntity(PermissionRole role) {
        // Implementa la lógica para convertir
        PermissionRoleE entity = new PermissionRoleE();
        entity.setId(role.getId());
        entity.setNameRole(role.getNameRole());
        return entity;
    }
    private CompanyE convertToEntity(Company company) {
        // Implementa la lógica para convertir
        CompanyE entity = new CompanyE();
        entity.setId(company.getId());
        entity.setNameCompany(company.getNameCompany());
        return entity;
    }

}