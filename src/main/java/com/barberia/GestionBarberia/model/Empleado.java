package com.barberia.GestionBarberia.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "empleados")
public class Empleado extends User{

    private String especialidad;

    private LocalDate fechaContratacion;

    private BigDecimal porcentajeComisión;

}
