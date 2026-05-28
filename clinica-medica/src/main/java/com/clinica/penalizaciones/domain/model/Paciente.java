package com.clinica.penalizaciones.domain.model;

import java.util.UUID;

public class Paciente {

    private UUID pacienteID;
    private Integer tipoDocumento;
    private String numDocumento;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private boolean tieneAlergias;
    private EstadoPaciente estado;

    public Paciente( UUID pacienteID, Integer tipoDocumento, String numDocumento,
                     String nombres, String apellidos, Integer edad, EstadoPaciente estado) {
        this.pacienteID = pacienteID;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estado = EstadoPaciente.ACTIVO;
    }
    public Paciente( Integer tipoDocumento, String numDocumento,
                    String nombres, String apellidos, Integer edad, EstadoPaciente estado) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estado = EstadoPaciente.ACTIVO;
    }

    public Paciente(UUID pacienteId, Integer tipoDocumento, String numDocumento, String nombres, String apellidos, Integer edad, String estado) {
        this.pacienteID = pacienteID;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estado = EstadoPaciente.ACTIVO;
    }


    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public UUID getPacienteID() {
        return pacienteID;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public EstadoPaciente getEstado() {
        return estado;
    }
}
