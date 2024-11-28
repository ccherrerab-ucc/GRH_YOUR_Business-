package com.tuempresa.rrhh.core.repository.request;


import com.tuempresa.rrhh.core.domain.request.Request;

import java.util.List;
import java.util.Optional;

public interface RequestRepository {

    Request save(Request request);

    Optional<Request> findById(Integer id);

    List<Request> findAll();

    void deleteById(String id);

}

