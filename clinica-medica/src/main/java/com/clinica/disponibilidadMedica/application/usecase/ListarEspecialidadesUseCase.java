package com.clinica.disponibilidadMedica.application.usecase;

import java.util.List;

import com.clinica.disponibilidadMedica.application.dto.EspecialidadResponse;

public interface ListarEspecialidadesUseCase {

    List<EspecialidadResponse> execute();
}
