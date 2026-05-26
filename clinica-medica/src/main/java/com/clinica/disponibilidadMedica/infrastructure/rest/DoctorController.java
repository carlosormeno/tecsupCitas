package com.clinica.disponibilidadMedica.infrastructure.rest;

import com.clinica.disponibilidadMedica.application.dto.CrearDoctorRequest;
import com.clinica.disponibilidadMedica.application.dto.DoctorResponse;
import com.clinica.disponibilidadMedica.application.usecase.ActualizarDoctorUseCase;
import com.clinica.disponibilidadMedica.application.usecase.CrearDoctorUseCase;
import com.clinica.disponibilidadMedica.application.usecase.EliminarDoctorUseCase;
import com.clinica.disponibilidadMedica.application.usecase.ListarDoctoresUseCase;
import com.clinica.disponibilidadMedica.application.usecase.ObtenerDoctorUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    private final CrearDoctorUseCase crearDoctorUseCase;
    private final ObtenerDoctorUseCase obtenerDoctorUseCase;
    private final ListarDoctoresUseCase listarDoctoresUseCase;
    private final ActualizarDoctorUseCase actualizarDoctorUseCase;
    private final EliminarDoctorUseCase eliminarDoctorUseCase;

    public DoctorController(CrearDoctorUseCase crearDoctorUseCase,
                             ObtenerDoctorUseCase obtenerDoctorUseCase,
                             ListarDoctoresUseCase listarDoctoresUseCase,
                             ActualizarDoctorUseCase actualizarDoctorUseCase,
                             EliminarDoctorUseCase eliminarDoctorUseCase) {
        this.crearDoctorUseCase = crearDoctorUseCase;
        this.obtenerDoctorUseCase = obtenerDoctorUseCase;
        this.listarDoctoresUseCase = listarDoctoresUseCase;
        this.actualizarDoctorUseCase = actualizarDoctorUseCase;
        this.eliminarDoctorUseCase = eliminarDoctorUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponse crear(@RequestBody CrearDoctorRequest request) {
        return crearDoctorUseCase.execute(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> obtener(@PathVariable UUID id) {
        return ResponseEntity.ok(obtenerDoctorUseCase.execute(id));
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> listar() {
        return ResponseEntity.ok(listarDoctoresUseCase.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> actualizar(@PathVariable UUID id,
                                                      @RequestBody CrearDoctorRequest request) {
        return ResponseEntity.ok(actualizarDoctorUseCase.execute(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable UUID id) {
        eliminarDoctorUseCase.execute(id);
    }
}
