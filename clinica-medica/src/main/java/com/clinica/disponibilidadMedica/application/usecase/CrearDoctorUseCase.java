package com.clinica.disponibilidadMedica.application.usecase;

import com.clinica.disponibilidadMedica.application.dto.CrearDoctorRequest;
import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;

public interface CrearDoctorUseCase {
    DoctorResponse execute(CrearDoctorRequest request);
}
