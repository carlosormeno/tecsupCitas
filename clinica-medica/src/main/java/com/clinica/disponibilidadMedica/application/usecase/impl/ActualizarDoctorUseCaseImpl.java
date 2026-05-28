package com.clinica.disponibilidadMedica.application.usecase.impl;

import com.clinica.disponibilidadMedica.application.dto.CrearDoctorRequest;
import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;
import com.clinica.disponibilidadMedica.application.usecase.ActualizarDoctorUseCase;
import com.clinica.disponibilidadMedica.domain.model.Doctor;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import com.clinica.shared.domain.exception.DomainException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class ActualizarDoctorUseCaseImpl implements ActualizarDoctorUseCase {

    private final DoctorRepository doctorRepository;

    public ActualizarDoctorUseCaseImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    @Override
    public DoctorResponse execute(UUID id, CrearDoctorRequest request) {
        doctorRepository.findById(id)
                .orElseThrow(() -> new DomainException("Doctor no encontrado: " + id));
        Doctor actualizado = new Doctor(id, request.nombre(), request.apellido(), request.especialidadId());
        Doctor guardado = doctorRepository.save(actualizado);
        return new DoctorResponse(guardado.getId(), guardado.getNombre(), guardado.getApellido(), guardado.getEspecialidadId());
    }
}
