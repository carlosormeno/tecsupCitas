package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.ConfirmarCitaUseCase;
import com.clinica.citas.domain.exception.CitaException;
import com.clinica.citas.domain.model.Cita;
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
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new CitaException("Cita no encontrada: " + citaId));
        cita.confirmar();
        Cita guardada = citaRepository.save(cita);
        return new CitaResponse(guardada.getId(), guardada.getPacienteId(), guardada.getDoctorId(),
                guardada.getEspecialidadId(), guardada.getFechaHora().getValor(), guardada.getEstado());
    }
}
