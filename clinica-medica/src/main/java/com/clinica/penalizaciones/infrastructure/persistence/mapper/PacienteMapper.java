package com.clinica.penalizaciones.infrastructure.persistence.mapper;

import com.clinica.penalizaciones.domain.model.EstadoPaciente;
import com.clinica.penalizaciones.domain.model.Paciente;
import com.clinica.penalizaciones.infrastructure.persistence.jpa.PacienteJpaEntity;
import com.clinica.penalizaciones.infrastructure.persistence.jpa.PacienteJpaRepository;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    default PacienteJpaEntity toEntity(Paciente paciente){
        if(paciente == null)
            return null;
        return PacienteJpaEntity.builder()
                .pacienteId(paciente.getPacienteID())
                .tipoDocumento(paciente.getTipoDocumento())
                .numDocumento(paciente.getNumDocumento())
                .edad(paciente.getEdad())
                .estado(paciente.getEstado().toString())
                .build();
    }

    default Paciente toDomain(PacienteJpaEntity entity){
        if(entity == null)
            return null;
        return new Paciente(
                entity.getPacienteId(),
                entity.getTipoDocumento(),
                entity.getNumDocumento(),
                entity.getNombres(),
                entity.getApellidos(),
                entity.getEdad(),
                entity.getEstado());
    }
}
