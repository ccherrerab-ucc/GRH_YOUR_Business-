package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.infrastructure.persintence.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAreaRepository extends JpaRepository<AreaEntity, Integer> {
}
