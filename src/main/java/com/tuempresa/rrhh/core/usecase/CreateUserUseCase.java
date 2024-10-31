package com.tuempresa.rrhh.core.usecase;

import com.tuempresa.rrhh.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Service;

import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.core.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(entity -> new User(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getStatus(), entity.getCompany().getId(), entity.getRole().getId()))
                .collect(Collectors.toList());
    }

    public User createUser(User user) {
        UserEntity userEntity = toEntity(user);
        userRepository.save(userEntity); // Asegúrate de que estás guardando la entidad

        // Crear un nuevo User a partir del UserEntity guardado
        return new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getStatus(), userEntity.getCompany().getId(),userEntity.getRole().getId());
    }

    private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setStatus(1);
        return entity;
    }
}
