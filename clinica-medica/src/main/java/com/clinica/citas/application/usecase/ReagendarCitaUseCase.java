package com.clinica.citas.application.usecase;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.domain.model.FechaHoraCita;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ReagendarCitaUseCase {

    private final CitaRepository citaRepository;

    public ReagendarCitaUseCase(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public CitaResponse execute(UUID citaId, LocalDateTime nuevaFechaHora) {
        return null;
    }
}
