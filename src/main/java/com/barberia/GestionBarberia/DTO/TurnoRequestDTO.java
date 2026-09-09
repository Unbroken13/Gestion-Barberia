package com.barberia.GestionBarberia.DTO;


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
    private Long clienteId;
    private Long empleadoId;

    //momento exacto de la reserva
    private LocalDateTime fechaHora;

    //lista de los IDs con los servicios que el cliente quiere realizarse
    private List<Long> servicioIds;


}
