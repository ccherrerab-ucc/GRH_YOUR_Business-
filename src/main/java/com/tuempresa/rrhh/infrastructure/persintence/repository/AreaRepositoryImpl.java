package com.tuempresa.rrhh.infrastructure.persintence.repository;

import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.repository.personal_data.AreaRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.AreaMapper;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.JpaAreaRepository;
import com.tuempresa.rrhh.infrastructure.persintence.entity.AreaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AreaRepositoryImpl implements AreaRepository {
    private final JpaAreaRepository jpaAreaRepository;
    private final AreaMapper areaMapper;

    @Autowired
    public AreaRepositoryImpl(JpaAreaRepository jpaAreaRepository, AreaMapper areaMapper) {
        this.jpaAreaRepository = jpaAreaRepository;
        this.areaMapper = areaMapper;
    }

    @Override
    public Optional<Area> findById(Integer id) {
        return jpaAreaRepository.findById(id).map(areaMapper::toDomain);
    }

    @Override
    public Area save(Area area) {
        AreaEntity areaEntity = areaMapper.toEntity(area);
        return areaMapper.toDomain(jpaAreaRepository.save(areaEntity));
    }
}
