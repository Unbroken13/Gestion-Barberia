package com.barberia.GestionBarberia.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    private Long id;

    private String nombre;
    private String apellido;
    private String username;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    // Métricas específicas del Cliente
    private Integer puntosFidelidad;
    private String notasPreferidas;
    private Integer abandonoDeTurnos;
    private Boolean activo;


    //La regla de oro: la contraseña jamás se incluye aquí.

    //Aquí SÍ incluimos el id.
    // El frontend necesita saber el ID de cada customer para que,

}
