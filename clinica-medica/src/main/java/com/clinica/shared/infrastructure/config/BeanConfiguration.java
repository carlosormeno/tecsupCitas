package com.clinica.shared.infrastructure.config;

import com.clinica.citas.application.usecase.AgendarCitaUseCase;
import com.clinica.citas.application.usecase.CancelarCitaUseCase;
import com.clinica.citas.application.usecase.ConfirmarCitaUseCase;
import com.clinica.citas.application.usecase.ReagendarCitaUseCase;
import com.clinica.citas.application.usecase.impl.AgendarCitaUseCaseImpl;
import com.clinica.citas.application.usecase.impl.CancelarCitaUseCaseImpl;
import com.clinica.citas.application.usecase.impl.ConfirmarCitaUseCaseImpl;
import com.clinica.citas.application.usecase.impl.ReagendarCitaUseCaseImpl;
import com.clinica.citas.domain.repository.CitaRepository;
import com.clinica.disponibilidadMedica.application.usecase.ActualizarDoctorUseCase;
import com.clinica.disponibilidadMedica.application.usecase.CrearDoctorUseCase;
import com.clinica.disponibilidadMedica.application.usecase.EliminarDoctorUseCase;
import com.clinica.disponibilidadMedica.application.usecase.ListarDoctoresUseCase;
import com.clinica.disponibilidadMedica.application.usecase.ObtenerDoctorUseCase;
import com.clinica.disponibilidadMedica.application.usecase.impl.ActualizarDoctorUseCaseImpl;
import com.clinica.disponibilidadMedica.application.usecase.impl.CrearDoctorUseCaseImpl;
import com.clinica.disponibilidadMedica.application.usecase.impl.EliminarDoctorUseCaseImpl;
import com.clinica.disponibilidadMedica.application.usecase.impl.ListarDoctoresUseCaseImpl;
import com.clinica.disponibilidadMedica.application.usecase.impl.ObtenerDoctorUseCaseImpl;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class BeanConfiguration {

    // ── Citas ──────────────────────────────────────────────────────────────

    @Bean
    public AgendarCitaUseCase agendarCitaUseCase(CitaRepository citaRepository) {
        return new AgendarCitaUseCaseImpl(citaRepository);
    }

    @Bean
    public CancelarCitaUseCase cancelarCitaUseCase(CitaRepository citaRepository) {
        return new CancelarCitaUseCaseImpl(citaRepository);
    }

    @Bean
    public ConfirmarCitaUseCase confirmarCitaUseCase(CitaRepository citaRepository) {
        return new ConfirmarCitaUseCaseImpl(citaRepository);
    }

    @Bean
    public ReagendarCitaUseCase reagendarCitaUseCase(CitaRepository citaRepository) {
        return new ReagendarCitaUseCaseImpl(citaRepository);
    }

    // ── Disponibilidad Médica (Doctor) ─────────────────────────────────────

    @Bean
    public CrearDoctorUseCase crearDoctorUseCase(DoctorRepository doctorRepository) {
        return new CrearDoctorUseCaseImpl(doctorRepository);
    }

    @Bean
    public ObtenerDoctorUseCase obtenerDoctorUseCase(DoctorRepository doctorRepository) {
        return new ObtenerDoctorUseCaseImpl(doctorRepository);
    }

    @Bean
    public ListarDoctoresUseCase listarDoctoresUseCase(DoctorRepository doctorRepository) {
        return new ListarDoctoresUseCaseImpl(doctorRepository);
    }

    @Bean
    public ActualizarDoctorUseCase actualizarDoctorUseCase(DoctorRepository doctorRepository) {
        return new ActualizarDoctorUseCaseImpl(doctorRepository);
    }

    @Bean
    public EliminarDoctorUseCase eliminarDoctorUseCase(DoctorRepository doctorRepository) {
        return new EliminarDoctorUseCaseImpl(doctorRepository);
    }
}
