package com.barberia.GestionBarberia.mapper;


import com.barberia.GestionBarberia.DTO.ServicioRequestDTO;
import com.barberia.GestionBarberia.DTO.ServicioResponseDTO;
import com.barberia.GestionBarberia.model.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    // 1. Convertir de DTO (que llega de internet) a Entidad
    // (para guardar en MySQL)
    Servicio toEntoty(ServicioRequestDTO dto);

    // 2. Convertir de Entidad (que sale de MySQL) a DTO
    // (para enviar a internet)
    ServicioResponseDTO toResponseDTO(Servicio entity);

}
