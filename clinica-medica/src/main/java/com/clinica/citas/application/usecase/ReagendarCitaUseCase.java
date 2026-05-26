package com.clinica.citas.application.usecase;

import com.clinica.citas.application.dto.CitaResponse;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ReagendarCitaUseCase {
    CitaResponse execute(UUID citaId, LocalDateTime nuevaFechaHora);
}
