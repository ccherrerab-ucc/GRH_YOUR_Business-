package com.tuempresa.rrhh.core.service;

import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.repository.personal_data.AreaRepository;
import com.tuempresa.rrhh.infrastructure.persintence.entity.AreaEntity;
import org.springframework.stereotype.Service;

@Service
public class AreaService {
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }


    public Area getAreaById(Integer id) {
        return areaRepository.findById(id).orElseThrow(() -> new RuntimeException("Área no encontrada"));
    }

    public Area createArea(Area area) {
        return areaRepository.save(area);
    }
}
