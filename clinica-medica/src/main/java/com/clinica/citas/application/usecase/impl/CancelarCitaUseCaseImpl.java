package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.CancelarCitaUseCase;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class CancelarCitaUseCaseImpl implements CancelarCitaUseCase {

    private final CitaRepository citaRepository;

    public CancelarCitaUseCaseImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Transactional
    @Override
    public CitaResponse execute(UUID citaId) {
        // TODO: buscar cita por id, lanzar CitaException si no existe
        // TODO: llamar cita.cancelar() para aplicar reglas de negocio
        // TODO: persistir con citaRepository.save()
        // TODO: mapear Cita → CitaResponse y retornar
        return null;
    }
}
