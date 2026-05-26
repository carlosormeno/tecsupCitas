package com.clinica.citas.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "citas")
@Getter
@Setter
@NoArgsConstructor
public class CitaJpaEntity {

    @Id
    private UUID id;

    @Column(name = "paciente_id", nullable = false)
    private UUID pacienteId;

    @Column(name = "doctor_id", nullable = false)
    private UUID doctorId;

    @Column(name = "especialidad_id", nullable = false)
    private UUID especialidadId;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false)
    private String estado;

    public CitaJpaEntity(UUID id, UUID pacienteId, UUID doctorId, UUID especialidadId,
                         LocalDateTime fechaHora, String estado) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.especialidadId = especialidadId;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }
}
