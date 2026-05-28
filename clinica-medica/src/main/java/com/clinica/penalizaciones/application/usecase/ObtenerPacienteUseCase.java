package com.clinica.penalizaciones.application.usecase;

import com.clinica.penalizaciones.application.dto.PacienteResponse;

import java.util.UUID;

public interface ObtenerPacienteUseCase {
    PacienteResponse execute(UUID pacienteId);
}
