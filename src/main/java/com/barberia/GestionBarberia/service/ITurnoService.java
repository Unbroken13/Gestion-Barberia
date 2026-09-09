package com.barberia.GestionBarberia.service;

import com.barberia.GestionBarberia.DTO.TurnoRequestDTO;
import com.barberia.GestionBarberia.DTO.TurnoResponseDTO;
import com.barberia.GestionBarberia.model.EstadoTurno;

import java.util.List;

public interface ITurnoService {

    // Contrato: Recibe un DTO de entrada y promete devolver un DTO de salida


    //crear turno
    TurnoResponseDTO crearTurno(TurnoRequestDTO dto);


    //buscar turnos por ID y Lista
    TurnoResponseDTO buscarPorID(Long id);

    List<TurnoResponseDTO> listarTurnos();



    //cambiar estado de turnos
    TurnoResponseDTO actualizarEstadoTurno(Long id, EstadoTurno estadoNuevo);


}
