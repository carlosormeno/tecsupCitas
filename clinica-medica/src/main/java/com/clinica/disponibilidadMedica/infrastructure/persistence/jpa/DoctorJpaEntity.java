package com.clinica.disponibilidadMedica.infrastructure.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "doctores")
@Getter
@Setter
@NoArgsConstructor
public class DoctorJpaEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "especialidad_id", nullable = false)
    private UUID especialidadId;

    public DoctorJpaEntity(UUID id, String nombre, String apellido, UUID especialidadId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidadId = especialidadId;
    }
}
