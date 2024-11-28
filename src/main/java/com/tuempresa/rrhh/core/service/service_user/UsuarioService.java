package com.tuempresa.rrhh.core.service.service_user;

import com.tuempresa.rrhh.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuempresa.rrhh.core.domain.User;


import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Object[]> getUsuarioByEmail(String email) {
        return userRepository.findByEmailWithRoleAndCompany(email);
    }
}
