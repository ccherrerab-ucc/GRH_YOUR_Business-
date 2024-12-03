package com.tuempresa.rrhh.infrastructure.persintence.repository;

import com.tuempresa.rrhh.core.domain.Workcenter;
import com.tuempresa.rrhh.core.repository.personal_data.WorkcenterRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.AreaMapper;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.JpaAreaRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.JpaWorkcenterRepository;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.WorkcenterMapper;
import com.tuempresa.rrhh.infrastructure.persintence.entity.AreaEntity;
import com.tuempresa.rrhh.infrastructure.persintence.entity.WorkcenterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class WorkcenterRepositoryImpl implements WorkcenterRepository {
    private final JpaWorkcenterRepository jpaWorkcenterRepository;
    private final WorkcenterMapper workcenterMapper;

    @Autowired
    public WorkcenterRepositoryImpl(JpaWorkcenterRepository jpaWorkcenterRepository, WorkcenterMapper workcenterMapper) {
        this.jpaWorkcenterRepository = jpaWorkcenterRepository;
        this.workcenterMapper = workcenterMapper;
    }

    @Override
    public Optional<Workcenter> findById(Integer id) {
        return jpaWorkcenterRepository.findById(id).map(workcenterMapper::toDomain);
    }

    @Override
    public Workcenter save(Workcenter workcenter) {
        WorkcenterEntity workcenterEntity = workcenterMapper.toEntity(workcenter);
        return workcenterMapper.toDomain(jpaWorkcenterRepository.save(workcenterEntity));
    }
}
