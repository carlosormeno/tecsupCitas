package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.ReagendarCitaUseCase;
import com.clinica.citas.domain.exception.CitaException;
import com.clinica.citas.domain.model.Cita;
import com.clinica.citas.domain.model.FechaHoraCita;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class ReagendarCitaUseCaseImpl implements ReagendarCitaUseCase {

    private final CitaRepository citaRepository;

    public ReagendarCitaUseCaseImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Transactional
    @Override
    public CitaResponse execute(UUID citaId, LocalDateTime nuevaFechaHora) {
        validarAnticipacion(nuevaFechaHora);
        validarHorarioAtencion(nuevaFechaHora);

        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new CitaException("Cita no encontrada: " + citaId));
        cita.reagendar(new FechaHoraCita(nuevaFechaHora));
        Cita guardada = citaRepository.save(cita);
        return new CitaResponse(guardada.getId(), guardada.getPacienteId(), guardada.getDoctorId(),
                guardada.getEspecialidadId(), guardada.getFechaHora().getValor(), guardada.getEstado());
    }

    private void validarAnticipacion(LocalDateTime fechaHora) {
        if (fechaHora.isBefore(LocalDateTime.now().plusHours(24))) {
            throw new CitaException("La cita debe reagendarse con al menos 24 horas de anticipación");
        }
    }

    private void validarHorarioAtencion(LocalDateTime fechaHora) {
        DayOfWeek dia = fechaHora.getDayOfWeek();
        if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
            throw new CitaException("Las citas solo pueden agendarse de lunes a viernes");
        }
        LocalTime hora = fechaHora.toLocalTime();
        if (hora.isBefore(LocalTime.of(8, 0)) || hora.isAfter(LocalTime.of(18, 0))) {
            throw new CitaException("Las citas solo pueden agendarse entre las 8:00 AM y las 6:00 PM");
        }
    }
}
