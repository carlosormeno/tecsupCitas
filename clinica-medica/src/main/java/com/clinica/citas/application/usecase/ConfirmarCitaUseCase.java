package com.clinica.citas.application.usecase;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConfirmarCitaUseCase {

    private final CitaRepository citaRepository;

    public ConfirmarCitaUseCase(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public CitaResponse execute(UUID citaId) {
        return null;
    }
}
