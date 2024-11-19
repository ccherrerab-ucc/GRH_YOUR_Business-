package com.tuempresa.rrhh.application.service.auth;

import com.tuempresa.rrhh.application.dto.auth.AuthResponse;
import com.tuempresa.rrhh.application.dto.auth.LoginRequest;
import com.tuempresa.rrhh.application.dto.auth.RegisterRequest;
import com.tuempresa.rrhh.application.service.jwt.JwtService;
import com.tuempresa.rrhh.application.service.service_user.CompanyService;
//import com.tuempresa.rrhh.application.service.service_user.PermissionRoleService;
import com.tuempresa.rrhh.application.service.service_user.PermissionRoleService;
import com.tuempresa.rrhh.core.domain.domain_user.Company;
import com.tuempresa.rrhh.core.domain.domain_user.PermissionRole;
import com.tuempresa.rrhh.core.repository.UserRepository;
import com.tuempresa.rrhh.infrastructure.entity.CompanyE;
import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import com.tuempresa.rrhh.infrastructure.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PermissionRoleService permissionRoleService;
    private final CompanyService companyService;

    /**
     * Método para manejar el inicio de sesión de un usuario.
     */
    public AuthResponse login(LoginRequest request) {
        // Autenticación del usuario
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // Generación de token JWT
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .message("Access Allowed")
                .build();
    }

    /**
     * Método alternativo de inicio de sesión (similar a login pero más compacto).
     */
    public AuthResponse logina(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    /**
     * Registro de un nuevo usuario.
     */
    public AuthResponse register(RegisterRequest request) {
        // Obtener roles y empresa
        PermissionRole role = permissionRoleService.getPermissionRoleById(request.getRole());
        Company company = companyService.getCompanyById(request.getCompany());

        // Convertir el dominio a entidad
        PermissionRoleE roleEntity = convertToEntity(role);
        CompanyE companyEntity = convertToEntity(company);

        // Encriptar contraseña
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // Crear la entidad de usuario
        UserEntity user = UserEntity.builder()
                .email(request.getEmail())
                .password(encodedPassword)
                .status(request.getStatus())
                .role(roleEntity)
                .company(companyEntity)
                .build();

        // Guardar el usuario en la base de datos
        userRepository.save(user);

        // Generar y retornar token de respuesta
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .message("User registered successfully")
                .build();
    }

    /**
     * Convierte un objeto de dominio PermissionRole a su entidad correspondiente.
     */
    private PermissionRoleE convertToEntity(PermissionRole role) {
        PermissionRoleE entity = new PermissionRoleE();
        entity.setId(role.getId());
        entity.setNameRole(role.getNameRole());
        return entity;
    }

    /**
     * Convierte un objeto de dominio Company a su entidad correspondiente.
     */
    private CompanyE convertToEntity(Company company) {
        CompanyE entity = new CompanyE();
        entity.setId(company.getId());
        entity.setNameCompany(company.getNameCompany());
        return entity;
    }
}
