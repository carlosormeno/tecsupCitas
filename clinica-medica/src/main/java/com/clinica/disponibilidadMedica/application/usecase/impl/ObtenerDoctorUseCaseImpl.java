package com.clinica.disponibilidadMedica.application.usecase.impl;

import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;
import com.clinica.disponibilidadMedica.application.usecase.ObtenerDoctorUseCase;
import com.clinica.disponibilidadMedica.domain.model.Doctor;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import com.clinica.shared.domain.exception.DomainException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class ObtenerDoctorUseCaseImpl implements ObtenerDoctorUseCase {

    private final DoctorRepository doctorRepository;

    public ObtenerDoctorUseCaseImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public DoctorResponse execute(UUID id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DomainException("Doctor no encontrado: " + id));
        return new DoctorResponse(doctor.getId(), doctor.getNombre(), doctor.getApellido(), doctor.getEspecialidadId());
    }
}
