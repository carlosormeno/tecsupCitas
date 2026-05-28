package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.CancelarCitaUseCase;
import com.clinica.citas.domain.exception.CitaException;
import com.clinica.citas.domain.model.Cita;
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
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new CitaException("Cita no encontrada: " + citaId));
        cita.cancelar();
        Cita guardada = citaRepository.save(cita);
        return new CitaResponse(guardada.getId(), guardada.getPacienteId(), guardada.getDoctorId(),
                guardada.getEspecialidadId(), guardada.getFechaHora().getValor(), guardada.getEstado());
    }
}
