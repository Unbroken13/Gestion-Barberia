package com.barberia.GestionBarberia.controller;

import com.barberia.GestionBarberia.DTO.EmpleadoRequestDTO;
import com.barberia.GestionBarberia.DTO.EmpleadoResponseDTO;
import com.barberia.GestionBarberia.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService empleadoServi;

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> crearEmpleado(@RequestBody EmpleadoRequestDTO requestDTO){
        EmpleadoResponseDTO newEmpleado = empleadoServi.crearEmpleado(requestDTO);

        return new ResponseEntity<>(newEmpleado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> mostrarTodosLosEmpleados(){

        List<EmpleadoResponseDTO> listaEmpleados = empleadoServi.listarTodosLosEmpleados();

        return new ResponseEntity<>(listaEmpleados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> mostarEmpleadoPorID(@PathVariable Long id){
        EmpleadoResponseDTO mostrarEmpleado = empleadoServi.buscarPorID(id);

        return new ResponseEntity<>(mostrarEmpleado, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizarEmpleadoPorID(@PathVariable Long id, @RequestBody EmpleadoRequestDTO dto){
        EmpleadoResponseDTO actualizarEmpleado = empleadoServi.actualizarEmpleado(id, dto);

        return new ResponseEntity<>(actualizarEmpleado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleadoPorID(@PathVariable Long id){
        empleadoServi.eliminarPorID(id);

        return ResponseEntity.noContent().build();
    }

}
