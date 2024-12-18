package com.tuempresa.rrhh.core.repository;

import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.role r LEFT JOIN FETCH u.company c WHERE u.email = :email")
    Optional<Object[]> findByEmailWithRoleAndCompany(@Param("email") String email);

    //Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findAll();
    UserEntity save(UserEntity user);
    Optional<UserEntity> findByEmail(String email);

}
