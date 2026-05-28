package com.clinica.penalizaciones.domain.repository;

import com.clinica.penalizaciones.domain.model.Paciente;

import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository {
    Paciente save(Paciente paciente);
    Optional<Paciente> findById(UUID pacienteId);
    //void updateEstadoPacienteById(UUID pacienteId, String estadoPaciente);
    //void deleteById(UUID pacienteId);
}
