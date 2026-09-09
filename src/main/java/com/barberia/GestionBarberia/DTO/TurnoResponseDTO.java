package com.barberia.GestionBarberia.DTO;


import com.barberia.GestionBarberia.model.EstadoTurno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TurnoResponseDTO {

    private Long id;
    private LocalDateTime fechaHora;
    private EstadoTurno estadoTurno;

    // Datos planos para el frontend, sin exponer entidades enteras
    private String nombreCliente;
    private String nombreBarbero;

    //integracion del DTO hijo: detallesTurnoDTO
    private List<DetallesTurnoResponseDTO> detalles;

    private BigDecimal precioTotal; //calcular en la logica back
    private Integer duracioTotalMinutos; //calcular en la logica back


}
