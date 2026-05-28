package com.clinica.penalizaciones.application.usecase;


import com.clinica.penalizaciones.application.dto.PacienteResponse;
import com.clinica.penalizaciones.application.dto.RegistrarPacienteRequest;

public interface RegistrarPacienteUseCase {
    PacienteResponse execute(RegistrarPacienteRequest request);

}
