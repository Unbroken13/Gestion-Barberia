package com.barberia.GestionBarberia.controller;

import com.barberia.GestionBarberia.DTO.CustomerRequestDTO;
import com.barberia.GestionBarberia.DTO.CustomerResponseDTO;
import com.barberia.GestionBarberia.service.CustomerService;
import com.barberia.GestionBarberia.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerServi;

    //(POST)
    // Endpoint para crear un nuevo producto
    // 1. Llama al metodo correspondiente de tu 'CustomerService' pasándole el requestDTO
    // y guarda el resultado en una variable tipo CustomeroResponseDTO.
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> crearCustomer(@RequestBody CustomerRequestDTO requesDto){
        CustomerResponseDTO newCustomer = customerServi.crearCustomer(requesDto);

        // 2. Retorna el ResponseEntity con estado HTTP 201 (CREATED) y el DTO en el cuerpo (body).
        // return ResponseEntity.status(HttpStatus.CREATED).body( ... );
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }


    //(GET)
    // Endpoint para obtener TODOS los Servicio
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> mostarTodosLosCustomers (){

        List<CustomerResponseDTO> listaCustomers = customerServi.listarTodosLosCustomer();

        return new ResponseEntity<>(listaCustomers, HttpStatus.OK);
    }


    //(GET)
    // Endpoint para obtener UN servicio ESPECIFICO {id}
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> mostarCustomerPorID(@PathVariable Long id){
        CustomerResponseDTO mostrarCustomer = customerServi.buscarPorID(id);

        return new ResponseEntity<>(mostrarCustomer, HttpStatus.OK);
    }


    //(PUT)
    // Endpoint para actualizar un servicio
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> actualizarCustomerPorID(@PathVariable Long id, @RequestBody CustomerRequestDTO requestDTO){
        CustomerResponseDTO actualizarCustomer = customerServi.actualizarCustomer(id, requestDTO);

        return new ResponseEntity<>(actualizarCustomer, HttpStatus.OK);
    }



    //(DELETE)
    // Endpoint para ELIMINAR un servicio
    //solo necesitas saber qué ID borrar.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCustomerPorID(@PathVariable Long id){
        customerServi.eliminarPorID(id);

        return ResponseEntity.noContent().build();
    }
}

























