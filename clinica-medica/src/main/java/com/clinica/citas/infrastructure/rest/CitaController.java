package com.clinica.citas.infrastructure.rest;

import com.clinica.citas.application.dto.AgendarCitaRequest;
import com.clinica.citas.application.dto.CitaResponse;
import com.clinica.citas.application.usecase.AgendarCitaUseCase;
import com.clinica.citas.application.usecase.CancelarCitaUseCase;
import com.clinica.citas.application.usecase.ConfirmarCitaUseCase;
import com.clinica.citas.application.usecase.ReagendarCitaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final AgendarCitaUseCase agendarCitaUseCase;
    private final CancelarCitaUseCase cancelarCitaUseCase;
    private final ConfirmarCitaUseCase confirmarCitaUseCase;
    private final ReagendarCitaUseCase reagendarCitaUseCase;

    public CitaController(AgendarCitaUseCase agendarCitaUseCase,
                          CancelarCitaUseCase cancelarCitaUseCase,
                          ConfirmarCitaUseCase confirmarCitaUseCase,
                          ReagendarCitaUseCase reagendarCitaUseCase) {
        this.agendarCitaUseCase = agendarCitaUseCase;
        this.cancelarCitaUseCase = cancelarCitaUseCase;
        this.confirmarCitaUseCase = confirmarCitaUseCase;
        this.reagendarCitaUseCase = reagendarCitaUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CitaResponse agendar(@RequestBody AgendarCitaRequest request) {
        return agendarCitaUseCase.execute(request);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<CitaResponse> cancelar(@PathVariable UUID id) {
        return ResponseEntity.ok(cancelarCitaUseCase.execute(id));
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<CitaResponse> confirmar(@PathVariable UUID id) {
        return ResponseEntity.ok(confirmarCitaUseCase.execute(id));
    }

    @PutMapping("/{id}/reagendar")
    public ResponseEntity<CitaResponse> reagendar(@PathVariable UUID id,
                                                   @RequestBody LocalDateTime nuevaFechaHora) {
        return ResponseEntity.ok(reagendarCitaUseCase.execute(id, nuevaFechaHora));
    }
}
