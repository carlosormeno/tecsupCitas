package com.clinica.penalizaciones.application.usecase;

import com.clinica.penalizaciones.application.dto.PacienteResponse;
import com.clinica.penalizaciones.application.dto.RegistrarPacienteRequest;

import java.util.UUID;

public interface  ModificarPacienteUseCase {
    PacienteResponse execute(UUID pacienteId, RegistrarPacienteRequest request);
}
