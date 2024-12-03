package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.infrastructure.persintence.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPositionRepository extends JpaRepository<PositionEntity, Integer> {
}
