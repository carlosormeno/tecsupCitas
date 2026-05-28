package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.AgendarCitaRequest;
import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.AgendarCitaUseCase;
import com.clinica.citas.domain.model.Cita;
import com.clinica.citas.domain.model.FechaHoraCita;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.transaction.annotation.Transactional;

public class AgendarCitaUseCaseImpl implements AgendarCitaUseCase {

    private final CitaRepository citaRepository;

    public AgendarCitaUseCaseImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Transactional
    @Override
    public CitaResponse execute(AgendarCitaRequest request) {
        Cita cita = new Cita(
                request.pacienteId(),
                request.doctorId(),
                request.especialidadId(),
                new FechaHoraCita(request.fechaHora())
        );
        Cita guardada = citaRepository.save(cita);
        return toResponse(guardada);
    }

    private CitaResponse toResponse(Cita cita) {
        return new CitaResponse(
                cita.getId(),
                cita.getPacienteId(),
                cita.getDoctorId(),
                cita.getEspecialidadId(),
                cita.getFechaHora().getValor(),
                cita.getEstado()
        );
    }
}
