package com.barberia.GestionBarberia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "empleados")
public class Empleado extends User{

    private String especialidad;

    private LocalDate fechaContratacion;

    private BigDecimal porcentajeComision;

}
