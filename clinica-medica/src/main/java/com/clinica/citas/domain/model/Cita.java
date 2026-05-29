package com.clinica.citas.domain.model;

import com.clinica.citas.domain.exception.CitaException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Cita {

    public static final int DURACION_MINUTOS = 30;

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

    public static void validarLimitePendientes(long citasPendientes) {
        if (citasPendientes >= 3) {
            throw new CitaException("El paciente ya tiene 3 citas pendientes, no puede agendar más");
        }
    }

    public void confirmar() {
        if (this.estado == EstadoCita.CANCELADA) {
            throw new CitaException("No se puede confirmar una cita cancelada");
        }
        this.estado = EstadoCita.CONFIRMADA;
    }

    public boolean generaPenalizacionAlCancelar() {
        return LocalDateTime.now().isAfter(this.fechaHora.getValor().minusHours(4));
    }

    public void cancelar() {
        if (this.estado == EstadoCita.CANCELADA) {
            throw new CitaException("La cita ya está cancelada");
        }
        this.estado = EstadoCita.CANCELADA;
    }

    public void reagendar(FechaHoraCita nuevaFechaHora) {
        if (this.estado == EstadoCita.CANCELADA) {
            throw new CitaException("No se puede reagendar una cita cancelada");
        }
        this.fechaHora = nuevaFechaHora;
        this.estado = EstadoCita.REAGENDADA;
    }

    public UUID getId() { return id; }
    public UUID getPacienteId() { return pacienteId; }
    public UUID getDoctorId() { return doctorId; }
    public UUID getEspecialidadId() { return especialidadId; }
    public FechaHoraCita getFechaHora() { return fechaHora; }
    public EstadoCita getEstado() { return estado; }
}
