package com.tuempresa.rrhh.core.repository.personal_data;


import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.domain.Workcenter;

import java.util.Optional;

public interface WorkcenterRepository {
    Optional<Workcenter> findById(Integer id);
    Workcenter save(Workcenter workcenter);
}
