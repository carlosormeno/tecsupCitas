package com.clinica.penalizaciones.application.usecase.impl;

import com.clinica.penalizaciones.application.dto.PacienteResponse;
import com.clinica.penalizaciones.application.usecase.ObtenerPacienteUseCase;
import com.clinica.penalizaciones.domain.model.Paciente;
import com.clinica.penalizaciones.domain.repository.PacienteRepository;
import com.clinica.shared.domain.exception.DomainException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class ObtenerPacienteUseCaseImpl  implements ObtenerPacienteUseCase {

    private final PacienteRepository pacienteRepository;

    public ObtenerPacienteUseCaseImpl(PacienteRepository pacienteRepository){ this.pacienteRepository = pacienteRepository;}

    @Transactional(readOnly = true)
    @Override
    public PacienteResponse execute(UUID pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new DomainException("Paciente no encontrado: "+ pacienteId));
        return new PacienteResponse(paciente.getPacienteID(), paciente.getTipoDocumento(), paciente.getNumDocumento(),
                paciente.getNombres(), paciente.getApellidos(), paciente.getEdad(),paciente.getEstado());
    }
}
