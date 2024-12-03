package com.tuempresa.rrhh.core.repository.personal_data;


import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.infrastructure.persintence.entity.AreaEntity;

import java.util.Optional;

public interface AreaRepository  {
    Optional<Area> findById(Integer id);
    Area save(Area area);
}
