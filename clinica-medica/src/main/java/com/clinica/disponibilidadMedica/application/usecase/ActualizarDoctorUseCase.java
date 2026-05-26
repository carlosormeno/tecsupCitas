package com.clinica.disponibilidadMedica.application.usecase;

import com.clinica.disponibilidadMedica.application.dto.CrearDoctorRequest;
import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;

import java.util.UUID;

public interface ActualizarDoctorUseCase {
    DoctorResponse execute(UUID id, CrearDoctorRequest request);
}
