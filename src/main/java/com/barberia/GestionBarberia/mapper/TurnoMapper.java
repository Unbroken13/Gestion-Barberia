package com.barberia.GestionBarberia.mapper;

import com.barberia.GestionBarberia.DTO.DetallesTurnoResponseDTO;
import com.barberia.GestionBarberia.DTO.TurnoRequestDTO;
import com.barberia.GestionBarberia.DTO.TurnoResponseDTO;
import com.barberia.GestionBarberia.model.DetalleTurno;
import com.barberia.GestionBarberia.model.Turno;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class TurnoMapper {

    // 1. Viaje de Ida: DTO -> Entidad (Para crear)
    public static Turno toEntity(TurnoRequestDTO dto){
        if (dto == null) return null;

        //buscamos el cliente, empleado y detalles dentro del TurnoService y los asignamos.
        return Turno.builder()
                .fechaHora(dto.getFechaHora())
                .build();
    }


    // 2. Viaje de Vuelta: Entidad -> DTO (Para responder)
    public static TurnoResponseDTO toDTO(Turno entity){
        if (entity == null) return null;

        //primero calcular los totales recorriendo los detalles:
        BigDecimal precioTotal = entity.getDetalleTurnos().stream()
                .map(DetalleTurno::getPrecioCobrado)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Integer duracionTotal = entity.getDetalleTurnos().stream()
                .mapToInt(DetalleTurno::getDuracionMinutos)
                .sum();

        return TurnoResponseDTO.builder()
                .id(entity.getId())
                .fechaHora(entity.getFechaHora())
                .estadoTurno(entity.getEstado())
                // obtener nombres de entidades relacionadas:
                .nombreCliente(entity.getCustomer().getNombre() + " " + entity.getCustomer().getNombre())
                .nombreBarbero(entity.getEmpleado().getNombre() + " " + entity.getEmpleado().getApellido())
                //mapear lista de detalles
                .detalles(entity.getDetalleTurnos().stream()
                        .map(TurnoMapper::detallesTurnoToDTO)
                        .collect(Collectors.toList()))
                .precioTotal(precioTotal)
                .duracioTotalMinutos(duracionTotal)
                .build();
    }


    private static DetallesTurnoResponseDTO detallesTurnoToDTO(DetalleTurno dto){
        if (dto == null) return null;

        return DetallesTurnoResponseDTO.builder()
                .id(dto.getId())
                .nombreServicio(dto.getServicio().getNombre())
                .precioCobrado(dto.getPrecioCobrado())
                .duracionMinutos(dto.getDuracionMinutos())
                .build();
    }


}
