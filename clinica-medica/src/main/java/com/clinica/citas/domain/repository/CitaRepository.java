package com.clinica.citas.domain.repository;

import com.clinica.citas.domain.model.Cita;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CitaRepository {
    Cita save(Cita cita);
    Optional<Cita> findById(UUID id);
    List<Cita> findByPacienteId(UUID pacienteId);
    List<Cita> findByDoctorId(UUID doctorId);
    void deleteById(UUID id);
}
