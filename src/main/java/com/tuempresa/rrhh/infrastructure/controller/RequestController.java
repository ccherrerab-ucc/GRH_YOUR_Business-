package com.tuempresa.rrhh.infrastructure.controller;

import com.tuempresa.rrhh.application.usecase.request.CreateRequestUseCase;
import com.tuempresa.rrhh.application.usecase.user.CreateUserUseCase;
import com.tuempresa.rrhh.core.domain.User;
import com.tuempresa.rrhh.core.domain.request.Request;
import com.tuempresa.rrhh.infrastructure.dto.UserDTO;
import com.tuempresa.rrhh.infrastructure.persintence.entity.EmployeeE;
import com.tuempresa.rrhh.infrastructure.persintence.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    private final CreateRequestUseCase createRequestUseCase;
    private final EmployeeRepository employeeRepository;


    public RequestController(CreateRequestUseCase createRequestUseCase, EmployeeRepository employeeRepository) {
        this.createRequestUseCase = createRequestUseCase;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Request createUser(@RequestBody Request request) {
        return createRequestUseCase.execute(request);
    }

     /*
    @GetMapping
    public ResponseEntity<List<Request>> getAllRequest() {
        List<User> users = createRequestUseCase.execute2(Request request);
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "employees")
    public ResponseEntity<List<EmployeeE>> getAllEmployees() {
        List<EmployeeE> users = employeeRepository.findAll();
        return ResponseEntity.ok(users);
    }
*/
}
