package com.clinica.citas.domain.model;

import java.time.LocalDateTime;

public class FechaHoraCita {
    private final LocalDateTime valor;

    public FechaHoraCita(LocalDateTime valor) {
        this.valor = valor;
    }

    public LocalDateTime getValor() { return valor; }
}
