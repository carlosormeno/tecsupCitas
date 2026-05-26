package com.clinica.citas.application.usecase;

import com.clinica.citas.application.dto.CitaResponse;

import java.util.UUID;

public interface ConfirmarCitaUseCase {
    CitaResponse execute(UUID citaId);
}
