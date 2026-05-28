package com.clinica.penalizaciones.application.usecase.impl;

import com.clinica.penalizaciones.application.dto.PacienteResponse;
import com.clinica.penalizaciones.application.dto.RegistrarPacienteRequest;
import com.clinica.penalizaciones.application.usecase.ModificarPacienteUseCase;
import com.clinica.penalizaciones.domain.model.Paciente;
import com.clinica.penalizaciones.domain.repository.PacienteRepository;
import com.clinica.shared.domain.exception.DomainException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class ModificarPacienteUseCaseImpl implements ModificarPacienteUseCase {

    private final PacienteRepository pacienteRepository;

    public ModificarPacienteUseCaseImpl(PacienteRepository pacienteRepository){this.pacienteRepository = pacienteRepository;}

    @Transactional
    @Override
    public PacienteResponse execute(UUID pacienteId, RegistrarPacienteRequest request){
        pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new DomainException("Paciente no encontrado: "+pacienteId));
        Paciente actualizado = new Paciente(pacienteId, request.tipoDocumento(), request.numDocumento(), request.nombres(), request.apellidos(),
                request.edad(), request.estado());
        Paciente guardado = pacienteRepository.save(actualizado);
        return new PacienteResponse(guardado.getPacienteID(), guardado.getTipoDocumento(), guardado.getNumDocumento(), guardado.getNombres(),
                guardado.getApellidos(), guardado.getEdad(),  guardado.getEstado());
    }

}
