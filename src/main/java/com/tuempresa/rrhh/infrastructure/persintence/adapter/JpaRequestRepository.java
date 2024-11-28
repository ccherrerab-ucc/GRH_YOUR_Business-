package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.infrastructure.persintence.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRequestRepository extends JpaRepository<RequestEntity,Long> {

}
