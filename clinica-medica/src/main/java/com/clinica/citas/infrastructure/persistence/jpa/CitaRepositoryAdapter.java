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
        return toDomain(jpaRepository.save(toEntity(cita)));
    }

    @Override
    public Optional<Cita> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Cita> findByPacienteId(UUID pacienteId) {
        return jpaRepository.findByPacienteId(pacienteId).stream().map(this::toDomain).toList();
    }

    @Override
    public List<Cita> findByDoctorId(UUID doctorId) {
        return jpaRepository.findByDoctorId(doctorId).stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    private CitaJpaEntity toEntity(Cita cita) {
        return new CitaJpaEntity(
                cita.getId(),
                cita.getPacienteId(),
                cita.getDoctorId(),
                cita.getEspecialidadId(),
                cita.getFechaHora().getValor(),
                cita.getEstado().name()
        );
    }

    private Cita toDomain(CitaJpaEntity entity) {
        return new Cita(
                entity.getId(),
                entity.getPacienteId(),
                entity.getDoctorId(),
                entity.getEspecialidadId(),
                new com.clinica.citas.domain.model.FechaHoraCita(entity.getFechaHora()),
                com.clinica.citas.domain.model.EstadoCita.valueOf(entity.getEstado())
        );
    }
}
