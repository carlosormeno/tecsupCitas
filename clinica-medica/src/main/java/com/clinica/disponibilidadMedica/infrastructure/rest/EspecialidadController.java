package com.clinica.disponibilidadMedica.infrastructure.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.disponibilidadMedica.application.dto.EspecialidadResponse;
import com.clinica.disponibilidadMedica.application.usecase.ListarEspecialidadesUseCase;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/especialidades")
@AllArgsConstructor
public class EspecialidadController {

    private final ListarEspecialidadesUseCase listarEspecialidadesUseCase;

    @GetMapping
    public ResponseEntity<List<EspecialidadResponse>> listar() {
        return ResponseEntity.ok(listarEspecialidadesUseCase.execute());
    }
}
