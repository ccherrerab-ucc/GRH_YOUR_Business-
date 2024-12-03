package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.infrastructure.persintence.entity.AreaEntity;
import org.springframework.stereotype.Component;

@Component
public class AreaMapper {

    public AreaEntity toEntity(Area area) {
        if (area == null) {
            return null;
        }
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setId(area.getId());
        areaEntity.setName_area(area.getName());
        return areaEntity;
    }

    public Area toDomain(AreaEntity areaEntity) {
        if (areaEntity == null) {
            return null;
        }
        Area area = new Area();
        area.setId(areaEntity.getId());
        area.setName(areaEntity.getName_area());
        return area;
    }
}
