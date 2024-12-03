package com.tuempresa.rrhh.core.repository.personal_data;


import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.domain.Position;

import java.util.Optional;

public interface PositionRepository {
    Optional<Position> findById(Integer id);
    Position save(Position position);
}
