package com.clinica.disponibilidadMedica.application.usecase.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.clinica.disponibilidadMedica.application.dto.EspecialidadResponse;
import com.clinica.disponibilidadMedica.application.usecase.ListarEspecialidadesUseCase;
import com.clinica.disponibilidadMedica.domain.repository.EspecialidadRepository;

public class ListarEspecialidadesUseCaseImpl implements ListarEspecialidadesUseCase {

    private final EspecialidadRepository especialidadRepository;

    public ListarEspecialidadesUseCaseImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EspecialidadResponse> execute() {
        return especialidadRepository.findAll().stream()
                .map(especialidad -> new EspecialidadResponse(
                        especialidad.getId(),
                        especialidad.getNombre(),
                        especialidad.getCosto()))
                .toList();
    }
}