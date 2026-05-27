package com.clinica.disponibilidadMedica.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.clinica.disponibilidadMedica.domain.model.Especialidad;
import com.clinica.disponibilidadMedica.domain.repository.EspecialidadRepository;
import com.clinica.disponibilidadMedica.infrastructure.persistence.jpa.EspecialidadJpaRepository;
import com.clinica.disponibilidadMedica.infrastructure.persistence.mapper.EspecialidadMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EspecialidadRepositoryAdapter implements EspecialidadRepository {

    private final EspecialidadJpaRepository jpaRepository;
    private final EspecialidadMapper mapper;

    @Override
    public Especialidad save(Especialidad especialidad) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(especialidad)));
    }

    @Override
    public Optional<Especialidad> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Especialidad> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }
}