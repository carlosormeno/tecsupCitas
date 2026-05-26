package com.clinica.citas.application.dto;

import com.clinica.citas.domain.model.EstadoCita;

import java.time.LocalDateTime;
import java.util.UUID;

public record CitaResponse(
        UUID id,
        UUID pacienteId,
        UUID doctorId,
        UUID especialidadId,
        LocalDateTime fechaHora,
        EstadoCita estado
) {}
