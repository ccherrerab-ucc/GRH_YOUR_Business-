package com.tuempresa.rrhh.infrastructure.persintence.repository.Request;

import com.tuempresa.rrhh.core.domain.request.Request;
import com.tuempresa.rrhh.core.repository.request.RequestRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.JpaRequestRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.RequestMapper;
import com.tuempresa.rrhh.infrastructure.persintence.entity.RequestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RequestRepositoryImpl implements RequestRepository {
    private final JpaRequestRepository jpaRequestRepository;

    public RequestRepositoryImpl(JpaRequestRepository jpaRequestRepository) {
        this.jpaRequestRepository = jpaRequestRepository;
    }
    @Override
    public Request save(Request request) {
        RequestEntity entity = RequestMapper.toEntity(request);
        RequestEntity savedEntity = jpaRequestRepository.save(entity);
        return RequestMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Request> findById(Integer id) {
        return jpaRequestRepository.findById(id.longValue())
                .map(RequestMapper::toDomain);
    }

    @Override
    public List<Request> findAll() {
        return jpaRequestRepository.findAll().stream()
                .map(RequestMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        jpaRequestRepository.deleteById(Long.parseLong(id));
    }
}
