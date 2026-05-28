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
import com.clinica.disponibilidadMedica.application.usecase.*;
import com.clinica.disponibilidadMedica.application.usecase.impl.*;
import com.clinica.disponibilidadMedica.domain.repository.DoctorRepository;
import com.clinica.disponibilidadMedica.domain.repository.EspecialidadRepository;
import com.clinica.penalizaciones.application.usecase.ModificarPacienteUseCase;
import com.clinica.penalizaciones.application.usecase.ObtenerPacienteUseCase;
import com.clinica.penalizaciones.application.usecase.RegistrarPacienteUseCase;
import com.clinica.penalizaciones.application.usecase.impl.ModificarPacienteUseCaseImpl;
import com.clinica.penalizaciones.application.usecase.impl.ObtenerPacienteUseCaseImpl;
import com.clinica.penalizaciones.application.usecase.impl.RegistrarPacienteUseCaseImpl;
import com.clinica.penalizaciones.domain.repository.PacienteRepository;
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

    // ──  Disponibilidad Médica(especialidades) ─────────────────────────────────────
    @Bean
    public ListarEspecialidadesUseCase listarEspecialidadesUseCase(EspecialidadRepository especialidadRepository){
        return new ListarEspecialidadesUseCaseImpl(especialidadRepository);
    }

    // ── Penalizaciones (paciente) ─────────────────────────────────────
    @Bean
    public RegistrarPacienteUseCase registrarPacienteUseCase(PacienteRepository pacienteRepository){
        return new RegistrarPacienteUseCaseImpl(pacienteRepository);
    }
    @Bean
    public ModificarPacienteUseCase modificarPacienteUseCase(PacienteRepository pacienteRepository){
        return new ModificarPacienteUseCaseImpl(pacienteRepository);
    }

    @Bean
    public ObtenerPacienteUseCase obtenerPacienteUseCase(PacienteRepository pacienteRepository){
        return new ObtenerPacienteUseCaseImpl(pacienteRepository);
    }

}
