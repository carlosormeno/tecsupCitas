package com.clinica.disponibilidadMedica.infrastructure.persistence.mapper;

import com.clinica.disponibilidadMedica.infrastructure.persistence.jpa.EspecialidadEntity;

import org.mapstruct.*;

import com.clinica.disponibilidadMedica.domain.model.Especialidad;

@Mapper(componentModel = "spring")
public interface EspecialidadMapper {

    default EspecialidadEntity toEntity(Especialidad especialidad) {
        if (especialidad == null)
            return null;
        return EspecialidadEntity.builder()
                .id(especialidad.getId())
                .nombre(especialidad.getNombre())
                .costo(especialidad.getCosto())
                .build();
    }

    default Especialidad toDomain(EspecialidadEntity entity) {
        if (entity == null)
            return null;
        return new Especialidad(
                entity.getId(),
                entity.getNombre(),
                entity.getCosto());
    }
}
