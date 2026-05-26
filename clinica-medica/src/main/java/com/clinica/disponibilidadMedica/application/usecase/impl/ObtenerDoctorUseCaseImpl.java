package com.clinica.disponibilidadMedica.application.usecase.impl;

import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;
import com.clinica.disponibilidadMedica.application.usecase.ObtenerDoctorUseCase;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
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
        // TODO: buscar doctor por id, lanzar excepción si no existe
        // TODO: mapear Doctor → DoctorResponse y retornar
        return null;
    }
}
