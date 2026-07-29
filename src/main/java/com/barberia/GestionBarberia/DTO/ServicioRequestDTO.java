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
public class ServicioRequestDTO {

    private String nombre;
    private Integer duracion;
    private BigDecimal precio;
    private String descripcion;

    //NO tiene el atributo id. ¿Por qué?
    // Porque cuando el dueño crea un servicio nuevo,
    // él no sabe ni debe decidir qué ID tendrá en la base de datos.
    // Eso es trabajo de MySQL (nuestro @GeneratedValue)

}
