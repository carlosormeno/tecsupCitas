package com.clinica.disponibilidadMedica.application.usecase.impl;

import com.clinica.disponibilidadMedica.application.dto.CrearDoctorRequest;
import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;
import com.clinica.disponibilidadMedica.application.usecase.CrearDoctorUseCase;
import com.clinica.disponibilidadMedica.domain.model.Doctor;
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
        Doctor doctor = new Doctor(request.nombre(), request.apellido(), request.especialidadId());
        Doctor guardado = doctorRepository.save(doctor);
        return toResponse(guardado);
    }

    private DoctorResponse toResponse(Doctor doctor) {
        return new DoctorResponse(doctor.getId(), doctor.getNombre(), doctor.getApellido(), doctor.getEspecialidadId());
    }
}
