package com.clinica.disponibilidadMedica.application.dto;

import java.util.UUID;

public record DoctorResponse(
        UUID id,
        String nombre,
        String apellido,
        UUID especialidadId
) {}
