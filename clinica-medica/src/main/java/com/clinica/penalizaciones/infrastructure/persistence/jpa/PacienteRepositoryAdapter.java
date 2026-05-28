package com.clinica.penalizaciones.infrastructure.persistence.jpa;

import com.clinica.penalizaciones.domain.model.Paciente;
import com.clinica.penalizaciones.domain.repository.PacienteRepository;
import com.clinica.penalizaciones.infrastructure.persistence.mapper.PacienteMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class PacienteRepositoryAdapter implements PacienteRepository {

    private final PacienteJpaRepository jpaRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteRepositoryAdapter(PacienteJpaRepository jpaRepository, PacienteMapper pacienteMapper) {
        this.jpaRepository = jpaRepository;
        this.pacienteMapper = pacienteMapper;
    }

    @Override
    public Paciente save(Paciente paciente) {
        return null;
    }

    @Override
    public Optional<Paciente> findById(UUID pacienteId) {
        return Optional.empty();
    }


    /*public void updateEstadoPacienteById(UUID pacienteId, String estadoPaciente) {

    }

    @Override
    public void deleteById(UUID pacienteId) {

    }*/
}
