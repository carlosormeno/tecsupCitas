package com.clinica.citas.application.usecase;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CancelarCitaUseCase {

    private final CitaRepository citaRepository;

    public CancelarCitaUseCase(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public CitaResponse execute(UUID citaId) {
        return null;
    }
}
