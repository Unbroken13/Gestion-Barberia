package com.barberia.GestionBarberia.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDTO {

    private LocalDateTime timesamp;
    private Integer status;
    private String error;
    private String message;
    private String path;


}
