package com.barberia.GestionBarberia.controller;


import com.barberia.GestionBarberia.DTO.ServicioRequestDTO;
import com.barberia.GestionBarberia.DTO.ServicioResponseDTO;
import com.barberia.GestionBarberia.model.Servicio;
import com.barberia.GestionBarberia.service.IServicioService;
import com.barberia.GestionBarberia.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/servicios")
@RequiredArgsConstructor
public class ServicioController {

    private final IServicioService servi;

    // Endpoint para crear un nuevo producto (POST)
    // 1. Llama al metodo correspondiente de tu 'servicioService' pasándole el requestDTO
    // y guarda el resultado en una variable tipo ServicioResponseDTO.
    @PostMapping
    public ResponseEntity<ServicioResponseDTO> crearServicio(@RequestBody ServicioRequestDTO requestDto){
        ServicioResponseDTO nuevoServicio = servi.crearServicio(requestDto);

        // 2. Retorna el ResponseEntity con estado HTTP 201 (CREATED) y el DTO en el cuerpo (body).
        // return ResponseEntity.status(HttpStatus.CREATED).body( ... );
        return new ResponseEntity<>(nuevoServicio, HttpStatus.CREATED);

    }


    // Endpoint para obtener todos los Servicio (GET)
    @GetMapping
    public ResponseEntity<List<ServicioResponseDTO>> mostrarTodosLosServicios(){

        List<ServicioResponseDTO> listaServicios = servi.listarTodosLosServicios();
        return new ResponseEntity<>(listaServicios, HttpStatus.OK);

    }

    // Endpoint para obtener un servicio especifico {id} (GET)
    @GetMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> mostrarServicioPorId(@PathVariable Long id){
        ServicioResponseDTO mostrarServicio = servi.buscarPorID(id);
        return new ResponseEntity<>(mostrarServicio, HttpStatus.OK);
    }

    // Endpoint para actualizar un servicio (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> actualizarServicioPorID(@PathVariable Long id, @RequestBody ServicioRequestDTO requestDTO){
        ServicioResponseDTO actualizarServicio = servi.actualizarServicio(id, requestDTO);
        return new ResponseEntity<>(actualizarServicio, HttpStatus.OK);
    }

    // Endpoint para ELIMINAR un servicio (DELETE)
    //solo necesitas saber qué ID borrar.

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicioPorID(@PathVariable Long id){
        servi.eliminarPorID(id);
        return  ResponseEntity.noContent().build();

    }


}
