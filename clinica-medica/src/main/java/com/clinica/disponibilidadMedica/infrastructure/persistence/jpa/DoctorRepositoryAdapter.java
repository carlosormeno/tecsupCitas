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
        // TODO: convertir Doctor → DoctorJpaEntity, persistir y retornar Doctor
        return null;
    }

    @Override
    public Optional<Doctor> findById(UUID id) {
        // TODO: buscar entity y mapear a Doctor
        return Optional.empty();
    }

    @Override
    public List<Doctor> findAll() {
        // TODO: obtener todas las entities y mapear a lista de Doctor
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {
        // TODO: jpaRepository.deleteById(id)
    }

    private DoctorJpaEntity toEntity(Doctor doctor) {
        // TODO: mapear campos de Doctor a DoctorJpaEntity
        return null;
    }

    private Doctor toDomain(DoctorJpaEntity entity) {
        // TODO: mapear campos de DoctorJpaEntity a Doctor
        return null;
    }
}
