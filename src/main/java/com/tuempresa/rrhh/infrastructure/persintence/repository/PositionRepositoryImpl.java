package com.tuempresa.rrhh.infrastructure.persintence.repository;

import com.tuempresa.rrhh.core.domain.Position;
import com.tuempresa.rrhh.core.repository.personal_data.PositionRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.AreaMapper;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.JpaAreaRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.JpaPositionRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.PositionMapper;
import com.tuempresa.rrhh.infrastructure.persintence.entity.PositionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class PositionRepositoryImpl implements PositionRepository {
    private final JpaPositionRepository jpaPositionRepository;
    private final PositionMapper positionMapper;

    @Autowired
    public PositionRepositoryImpl(JpaPositionRepository jpaPositionRepository, PositionMapper positionMapper) {
        this.jpaPositionRepository = jpaPositionRepository;
        this.positionMapper = positionMapper;
    }
    @Override
    public Optional<Position> findById(Integer id) {
        return jpaPositionRepository.findById(id).map(positionMapper::toDomain);
    }

    @Override
    public Position save(Position position) {
        PositionEntity positionEntity = positionMapper.toEntity(position);
        return positionMapper.toDomain(jpaPositionRepository.save(positionEntity));
    }
}
