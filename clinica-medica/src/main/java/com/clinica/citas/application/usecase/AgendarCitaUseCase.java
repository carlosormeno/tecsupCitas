package com.clinica.citas.application.usecase;

import com.clinica.citas.application.dto.AgendarCitaRequest;
import com.clinica.citas.application.dto.CitaResponse;

public interface AgendarCitaUseCase {
    CitaResponse execute(AgendarCitaRequest request);
}
