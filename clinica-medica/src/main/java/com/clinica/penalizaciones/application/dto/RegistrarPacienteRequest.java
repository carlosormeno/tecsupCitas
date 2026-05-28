package com.clinica.penalizaciones.application.dto;

import com.clinica.penalizaciones.domain.model.EstadoPaciente;

public record RegistrarPacienteRequest (
        Integer tipoDocumento,
        String numDocumento,
        String nombres,
        String apellidos,
        Integer edad,
        EstadoPaciente estado
){}
