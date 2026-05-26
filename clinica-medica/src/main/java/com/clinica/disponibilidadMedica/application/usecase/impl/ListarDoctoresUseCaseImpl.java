package com.clinica.disponibilidadMedica.application.usecase.impl;

import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;
import com.clinica.disponibilidadMedica.application.usecase.ListarDoctoresUseCase;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ListarDoctoresUseCaseImpl implements ListarDoctoresUseCase {

    private final DoctorRepository doctorRepository;

    public ListarDoctoresUseCaseImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<DoctorResponse> execute() {
        // TODO: obtener todos los doctores con doctorRepository.findAll()
        // TODO: mapear cada Doctor → DoctorResponse y retornar lista
        return List.of();
    }
}
