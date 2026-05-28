package com.clinica.penalizaciones.infrastructure.rest;

import com.clinica.penalizaciones.application.dto.PacienteResponse;
import com.clinica.penalizaciones.application.dto.RegistrarPacienteRequest;
import com.clinica.penalizaciones.application.usecase.ModificarPacienteUseCase;
import com.clinica.penalizaciones.application.usecase.ObtenerPacienteUseCase;
import com.clinica.penalizaciones.application.usecase.RegistrarPacienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final RegistrarPacienteUseCase registrarPacienteUseCase;
    private final ModificarPacienteUseCase modificarPacienteUseCase;
    private final ObtenerPacienteUseCase obtenerPacienteUseCase;


    public PacienteController(RegistrarPacienteUseCase registrarPacienteUseCase,
                              ModificarPacienteUseCase modificarPacienteUseCase,
                              ObtenerPacienteUseCase obtenerPacienteUseCase){
        this.registrarPacienteUseCase = registrarPacienteUseCase;
        this.modificarPacienteUseCase = modificarPacienteUseCase;
        this.obtenerPacienteUseCase = obtenerPacienteUseCase;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteResponse registrar(@RequestBody RegistrarPacienteRequest request){
        return registrarPacienteUseCase.execute(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> obtenerPaciente(@PathVariable UUID id) {
        return ResponseEntity.ok(obtenerPacienteUseCase.execute(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> actualizarPaciente(@PathVariable UUID id,
                                                               @RequestBody RegistrarPacienteRequest request){
        return ResponseEntity.ok(modificarPacienteUseCase.execute(id, request));
    }
}
