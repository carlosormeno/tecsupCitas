package com.clinica.disponibilidadMedica.application.usecase.impl;

import com.clinica.disponibilidadMedica.application.dto.CrearDoctorRequest;
import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;
import com.clinica.disponibilidadMedica.application.usecase.ActualizarDoctorUseCase;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
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
        // TODO: buscar doctor por id, lanzar excepción si no existe
        // TODO: actualizar los campos del doctor
        // TODO: persistir con doctorRepository.save()
        // TODO: mapear Doctor → DoctorResponse y retornar
        return null;
    }
}
