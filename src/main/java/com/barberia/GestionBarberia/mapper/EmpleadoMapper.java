package com.barberia.GestionBarberia.mapper;

import com.barberia.GestionBarberia.DTO.CustomerRequestDTO;
import com.barberia.GestionBarberia.DTO.EmpleadoRequestDTO;
import com.barberia.GestionBarberia.DTO.EmpleadoResponseDTO;
import com.barberia.GestionBarberia.model.Empleado;

public class EmpleadoMapper {

    // 1. Viaje de Ida: DTO -> Entidad (Para crear)
    public static Empleado toEntity(EmpleadoRequestDTO dto){
        if (dto == null) return null;

        return Empleado.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .fechaNacimiento(dto.getFechaNacimiento())
                .rol(dto.getRol())
                .especialidad(dto.getEspecialidad())
                .fechaContratacion(dto.getFechaContratacion())
                .porcentajeComision(dto.getPorcentajeComision())
                .activo(dto.getActivo())
                .build();
    }


    // 2. Viaje de Vuelta: Entidad -> DTO (Para responder)
    public static EmpleadoResponseDTO toDTO(Empleado entity){
        if (entity == null) return null;

        return EmpleadoResponseDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .username(entity.getUsername())
                .telefono(entity.getTelefono())
                .email(entity.getEmail())
                .fechaNacimiento(entity.getFechaNacimiento())
                .rol(entity.getRol())
                .especialidad(entity.getEspecialidad())
                .fechaContratacion(entity.getFechaContratacion())
                .porcentajeComision(entity.getPorcentajeComision())
                .activo(entity.getActivo())
                .build();

    }

}
