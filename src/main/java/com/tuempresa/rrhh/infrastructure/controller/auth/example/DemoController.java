package com.tuempresa.rrhh.infrastructure.controller.auth.example;

import com.tuempresa.rrhh.application.service.service_user.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RestController
@RequestMapping("auth/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "demo")
    public String welcome() {
        return "Welcome from secure endpoint";
    }
    @PostMapping("/email/{email}")
    public ResponseEntity<Optional<Object[]>> getUsuarioByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usuarioService.getUsuarioByEmail(email));

    }
}