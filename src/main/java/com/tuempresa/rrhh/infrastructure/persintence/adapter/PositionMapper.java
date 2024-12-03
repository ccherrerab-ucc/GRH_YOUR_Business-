package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.core.domain.Position;
import com.tuempresa.rrhh.infrastructure.persintence.entity.PositionEntity;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {

    public PositionEntity toEntity(Position position) {
        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setId(position.getId());
        positionEntity.setName_position(position.getName());
        positionEntity.setRole_position(position.getRole());
        return positionEntity;
    }

    public Position toDomain(PositionEntity positionEntity) {
        Position position = new Position();
        position.setId(positionEntity.getId());
        position.setName(positionEntity.getName_position());
        position.setRole(positionEntity.getRole_position());
        return position;
    }
}