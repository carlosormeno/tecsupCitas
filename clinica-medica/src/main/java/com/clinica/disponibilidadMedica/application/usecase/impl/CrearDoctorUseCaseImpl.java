package com.clinica.disponibilidadMedica.application.usecase.impl;

import com.clinica.disponibilidadMedica.application.dto.CrearDoctorRequest;
import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;
import com.clinica.disponibilidadMedica.application.usecase.CrearDoctorUseCase;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import org.springframework.transaction.annotation.Transactional;

public class CrearDoctorUseCaseImpl implements CrearDoctorUseCase {

    private final DoctorRepository doctorRepository;

    public CrearDoctorUseCaseImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    @Override
    public DoctorResponse execute(CrearDoctorRequest request) {
        // TODO: crear Doctor con los datos del request
        // TODO: persistir con doctorRepository.save()
        // TODO: mapear Doctor → DoctorResponse y retornar
        return null;
    }
}
