package com.clinica.disponibilidadMedica.infrastructure.persistence.mapper;

import com.clinica.disponibilidadMedica.domain.model.Doctor;
import com.clinica.disponibilidadMedica.infrastructure.persistence.jpa.DoctorJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    default DoctorJpaEntity toEntity(Doctor doctor) {
        if (doctor == null)
            return null;
        return DoctorJpaEntity.builder()
                .id(doctor.getId())
                .nombre(doctor.getNombre())
                .apellido(doctor.getApellido())
                .especialidadId(doctor.getEspecialidadId())
                .build();
    }

    default Doctor toDomain(DoctorJpaEntity entity) {
        if (entity == null)
            return null;
        return new Doctor(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getEspecialidadId());
    }
}
