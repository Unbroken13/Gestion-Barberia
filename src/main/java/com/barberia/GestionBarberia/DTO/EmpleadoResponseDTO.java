package com.barberia.GestionBarberia.DTO;

import com.barberia.GestionBarberia.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoResponseDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String username;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;

    //atributos específicos

    private Rol rol;
    private String especialidad;
    private LocalDate fechaContratacion;
    private BigDecimal porcentajeComision;
    private Boolean activo;



}
