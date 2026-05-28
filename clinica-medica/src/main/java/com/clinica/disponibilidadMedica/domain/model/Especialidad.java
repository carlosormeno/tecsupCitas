package com.clinica.disponibilidadMedica.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class Especialidad {

    private UUID id;
    private String nombre;
    private BigDecimal costo;

    public Especialidad(UUID id, String nombre, BigDecimal costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Especialidad(String nombre, BigDecimal costo) {
        validarNombre(nombre);
        validarCosto(costo);
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.costo = costo;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la especialidad es requerido");
        }
    }

    private void validarCosto(BigDecimal costo) {
        if (costo == null || costo.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El costo de la especialidad debe ser mayor a cero");
        }
    }
}