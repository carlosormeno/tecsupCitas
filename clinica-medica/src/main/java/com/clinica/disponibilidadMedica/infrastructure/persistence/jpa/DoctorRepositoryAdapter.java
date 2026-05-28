package com.clinica.disponibilidadMedica.infrastructure.persistence.jpa;

import com.clinica.disponibilidadMedica.domain.model.Doctor;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DoctorRepositoryAdapter implements DoctorRepository {

    private final DoctorJpaRepository jpaRepository;

    public DoctorRepositoryAdapter(DoctorJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return toDomain(jpaRepository.save(toEntity(doctor)));
    }

    @Override
    public Optional<Doctor> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Doctor> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    private DoctorJpaEntity toEntity(Doctor doctor) {
        return new DoctorJpaEntity(doctor.getId(), doctor.getNombre(), doctor.getApellido(), doctor.getEspecialidadId());
    }

    private Doctor toDomain(DoctorJpaEntity entity) {
        return new Doctor(entity.getId(), entity.getNombre(), entity.getApellido(), entity.getEspecialidadId());
    }
}
