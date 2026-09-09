package com.barberia.GestionBarberia.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetallesTurnoResponseDTO {

    private Long id;
    private String nombreServicio;
    private BigDecimal precioCobrado;
    private Integer duracionMinutos;


}
