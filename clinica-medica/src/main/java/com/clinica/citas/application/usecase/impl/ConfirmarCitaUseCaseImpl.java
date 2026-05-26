package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.ConfirmarCitaUseCase;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class ConfirmarCitaUseCaseImpl implements ConfirmarCitaUseCase {

    private final CitaRepository citaRepository;

    public ConfirmarCitaUseCaseImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Transactional
    @Override
    public CitaResponse execute(UUID citaId) {
        // TODO: buscar cita por id, lanzar CitaException si no existe
        // TODO: llamar cita.confirmar() para aplicar reglas de negocio
        // TODO: persistir con citaRepository.save()
        // TODO: mapear Cita → CitaResponse y retornar
        return null;
    }
}
