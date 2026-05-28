package com.clinica.penalizaciones.application.usecase.impl;

import com.clinica.penalizaciones.application.dto.PacienteResponse;
import com.clinica.penalizaciones.application.dto.RegistrarPacienteRequest;
import com.clinica.penalizaciones.application.usecase.RegistrarPacienteUseCase;
import com.clinica.penalizaciones.domain.model.Paciente;
import com.clinica.penalizaciones.domain.repository.PacienteRepository;
import org.springframework.transaction.annotation.Transactional;

public class RegistrarPacienteUseCaseImpl implements RegistrarPacienteUseCase {

    private final PacienteRepository pacienteRepository;

    public RegistrarPacienteUseCaseImpl(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    @Override
    public PacienteResponse execute(RegistrarPacienteRequest request) {
        Paciente paciente = new Paciente(request.tipoDocumento(), request.numDocumento(),request.nombres(), request.apellidos(),
                request.edad(), request.estado());
        Paciente guardado = pacienteRepository.save(paciente);
        return toResponse(guardado);
    }

    private PacienteResponse toResponse(Paciente paciente){
        return new PacienteResponse(paciente.getPacienteID(), paciente.getTipoDocumento(), paciente.getNumDocumento(),
               paciente.getNombres(), paciente.getApellidos(), paciente.getEdad(), paciente.getEstado());
    }
}
