package com.barberia.GestionBarberia.DTO;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnoRequestDTO {

    //identificador para las personas involucradas tanto empleado como cliente
    @NotNull(message = "El cliente es obligatorio")
    private Long clienteId;

    @NotNull(message = "El empleado es obligatorio")
    private Long empleadoId;

    //momento exacto de la reserva
    @NotNull(message = "La fecha y hora son obligatorias")
    @Future(message = "El turno debe ser en una fecha futura")
    private LocalDateTime fechaHora;

    //lista de los IDs con los servicios que el cliente quiere realizarse
    @NotEmpty(message = "Debe elegir al menos un servicio")
    private List<Long> servicioIds;


}
