package com.clinica.citas.infrastructure.persistence.jpa;

import com.clinica.citas.domain.model.Cita;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CitaRepositoryAdapter implements CitaRepository {

    private final CitaJpaRepository jpaRepository;

    public CitaRepositoryAdapter(CitaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Cita save(Cita cita) {
        return null;
    }

    @Override
    public Optional<Cita> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Cita> findByPacienteId(UUID pacienteId) {
        return List.of();
    }

    @Override
    public List<Cita> findByDoctorId(UUID doctorId) {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {
    }

    private CitaJpaEntity toEntity(Cita cita) {
        return null;
    }

    private Cita toDomain(CitaJpaEntity entity) {
        return null;
    }
}
