package com.barberia.GestionBarberia.service;

import com.barberia.GestionBarberia.DTO.CustomerRequestDTO;
import com.barberia.GestionBarberia.DTO.CustomerResponseDTO;

import java.util.List;

public interface ICustomerService {

    // Contrato: Recibe un DTO de entrada y promete devolver un DTO de salida


   CustomerResponseDTO crearCustomer(CustomerRequestDTO dto);

   CustomerResponseDTO buscarPorID(Long id);

   void eliminarPorID(Long id);

   List<CustomerResponseDTO> listarTodosLosCustomer();

   CustomerResponseDTO actualizarCustomer(Long id, CustomerRequestDTO customerDTO);


}
