package com.clinica.citas.application.usecase;

import com.clinica.citas.application.dto.CitaResponse;

import java.util.UUID;

public interface CancelarCitaUseCase {
    CitaResponse execute(UUID citaId);
}
