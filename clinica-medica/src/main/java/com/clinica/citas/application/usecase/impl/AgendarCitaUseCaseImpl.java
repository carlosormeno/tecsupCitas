package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.AgendarCitaRequest;
import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.AgendarCitaUseCase;
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
        // TODO: validar que el paciente existe y está activo (vía PacienteRepository)
        // TODO: validar que el doctor existe (vía DoctorRepository)
        // TODO: validar que la especialidad existe (vía EspecialidadRepository)
        // TODO: crear Cita con FechaHoraCita y estado PENDIENTE
        // TODO: persistir con citaRepository.save()
        // TODO: mapear Cita → CitaResponse y retornar
        return null;
    }
}
