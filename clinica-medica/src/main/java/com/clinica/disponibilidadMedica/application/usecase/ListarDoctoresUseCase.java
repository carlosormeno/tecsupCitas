package com.clinica.disponibilidadMedica.application.usecase;

import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;

import java.util.List;

public interface ListarDoctoresUseCase {
    List<DoctorResponse> execute();
}
