package com.barberia.GestionBarberia.mapper;

import com.barberia.GestionBarberia.DTO.ServicioRequestDTO;
import com.barberia.GestionBarberia.DTO.ServicioResponseDTO;
import com.barberia.GestionBarberia.model.Servicio;

public class ServicioMapper {

    // 1. Viaje de Ida: DTO -> Entidad (Para crear)
    public static Servicio toEntity (ServicioRequestDTO dto){
        if (dto == null) return null;

        return Servicio.builder()
                .nombre(dto.getNombre())
                .duracion(dto.getDuracion())
                .precio(dto.getPrecio())
                .descripcion(dto.getDescripcion())
                .build();
    }

    // 2. Viaje de Vuelta: Entidad -> DTO (Para responder)
    public static ServicioResponseDTO toDTO(Servicio entity){
        if (entity == null) return null;

        return ServicioResponseDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .duracion(entity.getDuracion())
                .precio(entity.getPrecio())
                .descripcion(entity.getDescripcion())
                .build();
    }





}
