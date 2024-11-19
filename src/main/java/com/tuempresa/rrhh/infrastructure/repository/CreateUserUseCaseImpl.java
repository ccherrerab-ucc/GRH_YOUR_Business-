package com.tuempresa.rrhh.infrastructure.repository;

import com.tuempresa.rrhh.core.domain.CreateUserCommand;
import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.core.domain.domain_user.Company;
import com.tuempresa.rrhh.core.domain.domain_user.PermissionRole;
import com.tuempresa.rrhh.core.repository.UserRepository;
import com.tuempresa.rrhh.core.repository.repository_user.CompanyRepository;
import com.tuempresa.rrhh.core.usecase.CreateUserUseCase;
import com.tuempresa.rrhh.infrastructure.entity.CompanyE;
import com.tuempresa.rrhh.infrastructure.entity.PermissionRoleE;
import com.tuempresa.rrhh.infrastructure.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final PermissionRoleJpaRepository  roleRepository;
    private final CompanyRepository companyRepository;

    public CreateUserUseCaseImpl(UserRepository userRepository, PermissionRoleJpaRepository roleRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(user -> new User(user.getId(), user.getEmail(),user.getPassword(), user.getRole().getId(), user.getCompany().getId(), user.getStatus() ))
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity createUser(CreateUserCommand command) {
//        PermissionRoleE role = roleRepository.findByName(command.getPermissionRole().getNameRole())
//                .orElseThrow(() -> new RuntimeException("Role not found"));
        //Company company = companyRepository.findByName(command.getCompany())
                //.orElseThrow(() -> new RuntimeException("Company not found"));
        PermissionRoleE role = new PermissionRoleE();
        role.setId(1);
        role.setNameRole("Role por defecto");

        CompanyE company = new CompanyE();
        company.setId(1);
        company.setNameCompany("Empresa Estándar");

        UserEntity user = new UserEntity();
        user.setEmail(command.getEmail());
        user.setPassword(command.getPassword());
        user.setRole(role);
        user.setCompany(company);

        // Guarda el usuario en la base de datos
        userRepository.save(user);

        return user;

    }
}
