package com.barberia.GestionBarberia.DTO;


import com.barberia.GestionBarberia.model.Rol;
import jakarta.validation.constraints.*;
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
public class EmpleadoRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El username es obligatorio")
    @Size(min = 4, max = 30, message = "El username debe tener entre 4 y 30 caracteres")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    private String email;

    @Past(message = "La fecha de nacimiento debe ser pasada")
    private LocalDate fechaNacimiento;

    //atributos específicos
    @NotNull(message = "El rol es obligatorio")
    private Rol rol;

    private String especialidad;

    private LocalDate fechaContratacion;

    @NotNull(message = "El porcentaje de comisión es obligatorio")
    @DecimalMin(value = "0.0", message = "La comisión no puede ser negativa")
    @DecimalMax(value = "100.0", message = "La comisión no puede superar 100")
    private BigDecimal porcentajeComision;

    private Boolean activo;


}
