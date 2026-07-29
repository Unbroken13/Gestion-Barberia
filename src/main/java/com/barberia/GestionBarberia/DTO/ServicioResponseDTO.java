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
public class ServicioResponseDTO {

    private Long id;
    private String nombre;
    private Integer duracion;
    private BigDecimal precio;
    private String descripcion;

    //Aquí SÍ incluimos el id.
    // El frontend necesita saber el ID de cada servicio para que,
    // si el cliente hace clic en "Eliminar Corte Premium",
    // el frontend sepa decirnos: "Elimina el servicio con el ID 5"
}
