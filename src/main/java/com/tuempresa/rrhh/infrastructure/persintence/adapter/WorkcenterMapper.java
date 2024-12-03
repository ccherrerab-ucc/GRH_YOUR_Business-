package com.tuempresa.rrhh.infrastructure.persintence.adapter;

import com.tuempresa.rrhh.core.domain.Workcenter;
import com.tuempresa.rrhh.infrastructure.persintence.entity.WorkcenterEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkcenterMapper {

    public WorkcenterEntity toEntity(Workcenter workcenter) {
        if (workcenter == null) {
            return null;
        }
        WorkcenterEntity workcenterEntity = new WorkcenterEntity();
        workcenterEntity.setId(workcenter.getId());
        workcenterEntity.setName_city(workcenter.getName()); // Aquí estamos mapeando el nombre
        return workcenterEntity;
    }

    // Convertir de entidad (WorkcenterEntity) a dominio (Workcenter)
    public Workcenter toDomain(WorkcenterEntity workcenterEntity) {
        if (workcenterEntity == null) {
            return null;
        }
        Workcenter workcenter = new Workcenter();
        workcenter.setId(workcenterEntity.getId());
        workcenter.setName(workcenterEntity.getName_city()); // Aquí estamos mapeando el nombre
        return workcenter;
    }
}
