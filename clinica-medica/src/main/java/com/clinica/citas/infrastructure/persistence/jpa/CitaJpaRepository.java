package com.clinica.citas.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CitaJpaRepository extends JpaRepository<CitaJpaEntity, UUID> {
    List<CitaJpaEntity> findByPacienteId(UUID pacienteId);
    List<CitaJpaEntity> findByDoctorId(UUID doctorId);
}
