package com.clinica.penalizaciones.application.dto;

import com.clinica.penalizaciones.domain.model.EstadoPaciente;

import java.util.UUID;

public record PacienteResponse(
    UUID pacienteId,
    Integer tipoDocumento,
    String numDocumento,
    String nombres,
    String apellidos,
    Integer edad,
    EstadoPaciente estado){}
