package com.clinica.disponibilidadMedica.infrastructure.persistence.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadJpaRepository extends JpaRepository<EspecialidadEntity, UUID> {

}
