package com.clinica.penalizaciones.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteJpaRepository extends JpaRepository<PacienteJpaEntity, UUID> {
    //void updateEstadoPacienteById(UUID pacienteId, String estadoPaciente);
}
