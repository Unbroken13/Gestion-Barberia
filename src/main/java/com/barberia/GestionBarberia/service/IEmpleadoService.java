package com.barberia.GestionBarberia.service;

import com.barberia.GestionBarberia.DTO.EmpleadoRequestDTO;
import com.barberia.GestionBarberia.DTO.EmpleadoResponseDTO;

import java.util.List;

public interface IEmpleadoService {

    // Contrato: Recibe un DTO de entrada y promete devolver un DTO de salida

    EmpleadoResponseDTO crearEmpleado(EmpleadoRequestDTO dto);

    EmpleadoResponseDTO buscarPorID(Long id);

    void eliminarPorID(Long id);

    List<EmpleadoResponseDTO> listarTodosLosEmpleados();

    EmpleadoResponseDTO actualizarEmpleado(Long id, EmpleadoRequestDTO empleadoDto);




}
