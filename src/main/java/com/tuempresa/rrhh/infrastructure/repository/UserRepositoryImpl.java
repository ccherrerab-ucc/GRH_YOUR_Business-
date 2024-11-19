/*package com.tuempresa.rrhh.infrastructure.repository;


import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.core.repository.UserRepository;
import com.tuempresa.rrhh.infrastructure.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        List<UserEntity> entities = entityManager.createQuery("FROM UserEntity", UserEntity.class).getResultList();
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        entityManager.persist(entity);
        entityManager.flush();
        return toDomain(entity); // Retornamos el objeto `User` desde `UserEntity`
    }

    private User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getEmail(), entity.getPassword(), entity.getStatus(), entity.getCompany().getId(), entity.getRole().getId());
    }

    private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setStatus(user.getStatus());
        return entity;
    }
}*/
