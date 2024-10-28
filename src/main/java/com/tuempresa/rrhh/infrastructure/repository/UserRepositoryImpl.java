/*package com.tuempresa.rrhh.infrastructure.repository;

import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.infrastructure.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl {
    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        UserEntity entity = new UserEntity(user.getEmail(), user.getPassword(), user.getStatus());
        UserEntity savedEntity = userRepository.save(entity);
        return new User(savedEntity.getId(), savedEntity.getEmail(), savedEntity.getPassword(), savedEntity.getStatus());
    }

    // Otros métodos CRUD adicionales (find, delete, etc.) pueden implementarse aquí
}*/