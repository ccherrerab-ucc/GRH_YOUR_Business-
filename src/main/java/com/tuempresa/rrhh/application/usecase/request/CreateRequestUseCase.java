package com.tuempresa.rrhh.application.usecase.request;

import com.tuempresa.rrhh.core.domain.request.Request;
import com.tuempresa.rrhh.core.repository.request.RequestRepository;
import com.tuempresa.rrhh.infrastructure.persintence.entity.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateRequestUseCase {
    private final RequestRepository requestRepository;

    public CreateRequestUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request execute(Request request) {
        //Request requestExecute = new Request(request.getId(), request.getDateRequest(), request.getComment(), request.getDateStart(), request.getDateFinal(), request.getEmployees(), request.getStatusCode(), request.getIdTipeRequest());
        //RequestEntity requestEntity;
        return requestRepository.save(request);
    }

    public Optional<Request> execute2(Request request) {
        Request requestExecute = new Request(request.getId(), request.getDateRequest(), request.getComment(), request.getDateStart(), request.getDateFinal(), request.getEmployees(), request.getStatusCode(), request.getIdTipeRequest());

        return requestRepository.findById(0);
    }

}
