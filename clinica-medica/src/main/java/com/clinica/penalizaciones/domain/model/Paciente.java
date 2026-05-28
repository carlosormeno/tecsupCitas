package com.clinica.penalizaciones.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Paciente {

    private UUID pacienteID;
    private Integer tipoDocumento;
    private String numDocumento;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private EstadoPaciente estado;

    public Paciente( UUID pacienteID, Integer tipoDocumento, String numDocumento,
                     String nombres, String apellidos, Integer edad, EstadoPaciente estado) {
        this.pacienteID = pacienteID;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estado = estado;
    }
    public Paciente( Integer tipoDocumento, String numDocumento,
                    String nombres, String apellidos, Integer edad, EstadoPaciente estado) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estado = estado;
    }

}
