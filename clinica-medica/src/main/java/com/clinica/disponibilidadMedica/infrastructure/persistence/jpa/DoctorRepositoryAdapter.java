package com.clinica.disponibilidadMedica.infrastructure.persistence.jpa;

import com.clinica.disponibilidadMedica.domain.model.Doctor;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import com.clinica.disponibilidadMedica.infrastructure.persistence.mapper.DoctorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DoctorRepositoryAdapter implements DoctorRepository {

    private final DoctorJpaRepository jpaRepository;
    private final DoctorMapper doctorMapper;

    public DoctorRepositoryAdapter(DoctorJpaRepository jpaRepository, DoctorMapper doctorMapper) {
        this.jpaRepository = jpaRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorMapper.toDomain(jpaRepository.save(doctorMapper.toEntity(doctor)));
    }

    @Override
    public Optional<Doctor> findById(UUID id) {
        return jpaRepository.findById(id).map(doctorMapper::toDomain);
    }

    @Override
    public List<Doctor> findAll() {
        return jpaRepository.findAll().stream().map(doctorMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
