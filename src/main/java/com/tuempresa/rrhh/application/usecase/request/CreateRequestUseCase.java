package com.tuempresa.rrhh.application.usecase.request;

import com.tuempresa.rrhh.core.domain.request.Request;
import com.tuempresa.rrhh.core.repository.UserRepository;
import com.tuempresa.rrhh.core.repository.request.RequestRepository;
import org.springframework.stereotype.Service;

//@Service
public class CreateRequestUseCase {
    private final RequestRepository requestRepository;

    public CreateRequestUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request execute(Request request) {
        Request requestExecute = new Request(request.getId(), request.getDateRequest(), request.getComment(), request.getDateStart(), request.getDateFinal(), request.getEmployees(), request.getStatusCode(), request.getIdTipeRequest());

        return requestRepository.save(request);
    }

}
