package com.barberia.GestionBarberia.controller;


import com.barberia.GestionBarberia.DTO.TurnoRequestDTO;
import com.barberia.GestionBarberia.DTO.TurnoResponseDTO;
import com.barberia.GestionBarberia.service.ITurnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turnos")
@RequiredArgsConstructor
public class TurnoController {

    private final ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<TurnoResponseDTO> crearTurno(@Valid @RequestBody TurnoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.crearTurno(dto));
    }

    @GetMapping
    public ResponseEntity<List<TurnoResponseDTO>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.buscarPorID(id));
    }

}
