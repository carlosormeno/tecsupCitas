package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.ReagendarCitaUseCase;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReagendarCitaUseCaseImpl implements ReagendarCitaUseCase {

    private final CitaRepository citaRepository;

    public ReagendarCitaUseCaseImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Transactional
    @Override
    public CitaResponse execute(UUID citaId, LocalDateTime nuevaFechaHora) {
        // TODO: buscar cita por id, lanzar CitaException si no existe
        // TODO: llamar cita.reagendar(nuevaFechaHora)
        // TODO: persistir con citaRepository.save()
        // TODO: mapear Cita → CitaResponse y retornar
        return null;
    }
}
