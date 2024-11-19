package com.tuempresa.rrhh.core.usecase;

import com.tuempresa.rrhh.core.domain.CreateUserCommand;
import com.tuempresa.rrhh.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Service;

import com.tuempresa.rrhh.core.domain.User;

import java.util.List;

@Service
public interface  CreateUserUseCase  {

//    private final UserRepository userRepository;
//
//    public CreateUserUseCase(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<User> getAllUsers();

    public UserEntity createUser(CreateUserCommand command);
}
