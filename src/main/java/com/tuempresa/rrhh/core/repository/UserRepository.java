package com.tuempresa.rrhh.core.repository;

import com.tuempresa.rrhh.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // Métodos adicionales si es necesario
}
