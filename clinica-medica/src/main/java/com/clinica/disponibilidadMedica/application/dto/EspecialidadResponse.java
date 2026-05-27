package com.clinica.disponibilidadMedica.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record EspecialidadResponse(
        UUID id,
        String nombre,
        BigDecimal costo) {
}