package com.clinica.citas.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendarCitaRequest(
        UUID pacienteId,
        UUID doctorId,
        UUID especialidadId,
        LocalDateTime fechaHora
) {}
