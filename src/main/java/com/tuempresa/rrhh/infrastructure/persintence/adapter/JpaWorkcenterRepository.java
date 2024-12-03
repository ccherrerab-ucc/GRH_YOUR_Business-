package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.infrastructure.persintence.entity.WorkcenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWorkcenterRepository extends JpaRepository<WorkcenterEntity, Integer> {

}
