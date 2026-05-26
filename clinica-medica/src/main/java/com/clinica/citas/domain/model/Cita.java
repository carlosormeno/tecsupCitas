package com.clinica.citas.domain.model;

import java.util.UUID;

public class Cita {

    private UUID id;
    private UUID pacienteId;
    private UUID doctorId;
    private UUID especialidadId;
    private FechaHoraCita fechaHora;
    private EstadoCita estado;

    public Cita(UUID pacienteId, UUID doctorId, UUID especialidadId, FechaHoraCita fechaHora) {
        this.id = UUID.randomUUID();
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.especialidadId = especialidadId;
        this.fechaHora = fechaHora;
        this.estado = EstadoCita.PENDIENTE;
    }

    // Constructor para reconstitución desde persistencia
    public Cita(UUID id, UUID pacienteId, UUID doctorId, UUID especialidadId,
                FechaHoraCita fechaHora, EstadoCita estado) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.especialidadId = especialidadId;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public void confirmar() {
    }

    public void cancelar() {
    }

    public void reagendar(FechaHoraCita nuevaFechaHora) {
    }

    public UUID getId() { return id; }
    public UUID getPacienteId() { return pacienteId; }
    public UUID getDoctorId() { return doctorId; }
    public UUID getEspecialidadId() { return especialidadId; }
    public FechaHoraCita getFechaHora() { return fechaHora; }
    public EstadoCita getEstado() { return estado; }
}
