package com.clinica.disponibilidadMedica.application.dto;

import java.util.UUID;

public record CrearDoctorRequest(
        String nombre,
        String apellido,
        UUID especialidadId
) {}
