package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.ReagendarCitaUseCase;
import com.clinica.citas.domain.exception.CitaException;
import com.clinica.citas.domain.model.Cita;
import com.clinica.citas.domain.model.FechaHoraCita;
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
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new CitaException("Cita no encontrada: " + citaId));
        cita.reagendar(new FechaHoraCita(nuevaFechaHora));
        Cita guardada = citaRepository.save(cita);
        return new CitaResponse(guardada.getId(), guardada.getPacienteId(), guardada.getDoctorId(),
                guardada.getEspecialidadId(), guardada.getFechaHora().getValor(), guardada.getEstado());
    }
}
