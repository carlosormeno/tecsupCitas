package com.clinica.citas.application.usecase.impl;

import com.clinica.citas.application.dto.AgendarCitaRequest;
import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.AgendarCitaUseCase;
import com.clinica.citas.domain.exception.CitaException;
import com.clinica.citas.domain.model.Cita;
import com.clinica.citas.domain.model.EstadoCita;
import com.clinica.citas.domain.model.FechaHoraCita;
import com.clinica.citas.domain.repository.CitaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AgendarCitaUseCaseImpl implements AgendarCitaUseCase {

    private final CitaRepository citaRepository;

    public AgendarCitaUseCaseImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Transactional
    @Override
    public CitaResponse execute(AgendarCitaRequest request) {
        validarAnticipacion(request.fechaHora());
        validarHorarioAtencion(request.fechaHora());
        validarMaxCitasPendientes(request);

        Cita cita = new Cita(
                request.pacienteId(),
                request.doctorId(),
                request.especialidadId(),
                new FechaHoraCita(request.fechaHora())
        );
        Cita guardada = citaRepository.save(cita);
        return toResponse(guardada);
    }

    private void validarAnticipacion(LocalDateTime fechaHora) {
        if (fechaHora.isBefore(LocalDateTime.now().plusHours(24))) {
            throw new CitaException("La cita debe agendarse con al menos 24 horas de anticipación");
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

    private void validarMaxCitasPendientes(AgendarCitaRequest request) {
        long pendientes = citaRepository.findByPacienteId(request.pacienteId()).stream()
                .filter(c -> c.getEstado() == EstadoCita.PENDIENTE)
                .count();
        Cita.validarLimitePendientes(pendientes);
    }

    private CitaResponse toResponse(Cita cita) {
        return new CitaResponse(
                cita.getId(),
                cita.getPacienteId(),
                cita.getDoctorId(),
                cita.getEspecialidadId(),
                cita.getFechaHora().getValor(),
                cita.getEstado()
        );
    }
}
