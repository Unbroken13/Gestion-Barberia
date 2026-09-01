package com.barberia.GestionBarberia.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {

    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

}
