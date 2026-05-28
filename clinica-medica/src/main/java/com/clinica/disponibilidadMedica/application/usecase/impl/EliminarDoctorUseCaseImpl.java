package com.clinica.disponibilidadMedica.application.usecase.impl;

import com.clinica.disponibilidadMedica.application.usecase.EliminarDoctorUseCase;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import com.clinica.shared.domain.exception.DomainException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class EliminarDoctorUseCaseImpl implements EliminarDoctorUseCase {

    private final DoctorRepository doctorRepository;

    public EliminarDoctorUseCaseImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    @Override
    public void execute(UUID id) {
        doctorRepository.findById(id)
                .orElseThrow(() -> new DomainException("Doctor no encontrado: " + id));
        doctorRepository.deleteById(id);
    }
}
