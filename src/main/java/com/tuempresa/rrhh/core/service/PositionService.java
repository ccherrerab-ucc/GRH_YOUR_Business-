package com.tuempresa.rrhh.core.service;

import com.tuempresa.rrhh.core.domain.Position;
import com.tuempresa.rrhh.core.repository.personal_data.PositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    public Position getPositionById(Integer id) {
        return positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Área no encontrada"));
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }
}
