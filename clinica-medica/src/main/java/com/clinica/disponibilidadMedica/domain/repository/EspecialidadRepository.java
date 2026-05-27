package com.clinica.disponibilidadMedica.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.clinica.disponibilidadMedica.domain.model.Especialidad;

public interface EspecialidadRepository {

    Especialidad save(Especialidad especialidad);

    Optional<Especialidad> findById(UUID id);

    List<Especialidad> findAll();
}
