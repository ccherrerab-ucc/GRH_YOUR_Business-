package com.tuempresa.rrhh.core.service;

import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.domain.Workcenter;
import com.tuempresa.rrhh.core.repository.personal_data.AreaRepository;
import com.tuempresa.rrhh.core.repository.personal_data.WorkcenterRepository;
import com.tuempresa.rrhh.infrastructure.persintence.entity.WorkcenterEntity;
import org.springframework.stereotype.Service;

@Service
public class WorkcenterService {
    private final WorkcenterRepository workcenterRepository;

    public WorkcenterService(WorkcenterRepository workcenterRepository) {
        this.workcenterRepository = workcenterRepository;
    }


    public Workcenter getWorkcenterById(Integer id) {
        return workcenterRepository.findById(id).orElseThrow(() -> new RuntimeException("Área no encontrada"));
    }

    public Workcenter createWorkcenter(Workcenter workcenter) {
        return workcenterRepository.save(workcenter);
    }
}