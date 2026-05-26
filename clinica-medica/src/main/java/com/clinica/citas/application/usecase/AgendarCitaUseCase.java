package com.clinica.citas.application.usecase;

import com.clinica.citas.application.dto.AgendarCitaRequest;
import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendarCitaUseCase {

    private final CitaRepository citaRepository;

    public AgendarCitaUseCase(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public CitaResponse execute(AgendarCitaRequest request) {
        return null;
    }
}
