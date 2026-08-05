package com.barberia.GestionBarberia.service;

import com.barberia.GestionBarberia.DTO.ServicioRequestDTO;
import com.barberia.GestionBarberia.DTO.ServicioResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IServicioService {

    // Contrato: Recibe un DTO de entrada y promete devolver un DTO de salida
    ServicioResponseDTO crearServicio(ServicioRequestDTO dto);

    ServicioResponseDTO buscarPorID(Long id);

    void eliminarPorID(Long id);

    List<ServicioResponseDTO> listarTodosLosServicios();

    ServicioResponseDTO actualizarServicio(Long id, ServicioRequestDTO servicioDTO);

}
