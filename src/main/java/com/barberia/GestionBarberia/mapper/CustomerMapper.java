package com.barberia.GestionBarberia.mapper;

import com.barberia.GestionBarberia.DTO.CustomerRequestDTO;
import com.barberia.GestionBarberia.DTO.CustomerResponseDTO;
import com.barberia.GestionBarberia.model.Customer;

public class CustomerMapper {


    // 1. Viaje de Ida: DTO -> Entidad (Para crear)
    public static Customer toEntity (CustomerRequestDTO dto){
        if (dto == null) return null;

        return Customer.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .password(dto.getPassword())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .fechaNacimiento(dto.getFechaNacimiento())
                .build();
    }

    // 2. Viaje de Vuelta: Entidad -> DTO (Para responder)
    public static CustomerResponseDTO toDTO(Customer entity){
        if (entity == null) return null;

        return CustomerResponseDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .telefono(entity.getTelefono())
                .email(entity.getEmail())
                .fechaNacimiento(entity.getFechaNacimiento())
                .build();
    }



}
