package com.clinica.disponibilidadMedica.domain.repository;

import com.clinica.disponibilidadMedica.domain.model.Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository {
    Doctor save(Doctor doctor);
    Optional<Doctor> findById(UUID id);
    List<Doctor> findAll();
    void deleteById(UUID id);
}
