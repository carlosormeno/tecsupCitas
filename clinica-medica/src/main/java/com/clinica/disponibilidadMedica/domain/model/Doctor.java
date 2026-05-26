package com.clinica.disponibilidadMedica.domain.model;

import java.util.UUID;

public class Doctor {

    private UUID id;
    private String nombre;
    private String apellido;
    private UUID especialidadId;

    public Doctor(String nombre, String apellido, UUID especialidadId) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidadId = especialidadId;
    }

    public Doctor(UUID id, String nombre, String apellido, UUID especialidadId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidadId = especialidadId;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public UUID getEspecialidadId() { return especialidadId; }
}
