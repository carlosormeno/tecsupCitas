package com.clinica.disponibilidadMedica.application.usecase;

import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;

import java.util.UUID;

public interface ObtenerDoctorUseCase {
    DoctorResponse execute(UUID id);
}
