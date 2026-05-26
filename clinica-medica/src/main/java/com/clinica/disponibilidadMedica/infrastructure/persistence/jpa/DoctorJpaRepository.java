package com.clinica.disponibilidadMedica.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorJpaRepository extends JpaRepository<DoctorJpaEntity, UUID> {
}
