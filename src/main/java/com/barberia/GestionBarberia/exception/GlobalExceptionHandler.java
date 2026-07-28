package com.barberia.GestionBarberia.exception;


import com.barberia.GestionBarberia.DTO.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice // 1. Convierte esta clase en el "paraguas" interceptor global.
public class GlobalExceptionHandler {

    // 2. Le decimos a Spring: "Si alguien lanza un RuntimeException, ejecuta este metodo".
    public ResponseEntity<ErrorResponseDTO> manejarErrorGenerico(RuntimeException exception, HttpServletRequest request){
        // 3. Construimos nuestro DTO usando el @Builder que nos dio Lombok
        ErrorResponseDTO errorDTO = ErrorResponseDTO.builder()
                .timesamp(LocalDateTime.now()) // Fecha y hora actual
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value()) // Código 500
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()) // "Internal Server Error"
                .message(exception.getMessage()) // El mensaje exacto de la excepción lanzada
                .path(request.getRequestURI()) // La URL que provocó el error (ej. /api/v1/turnos)
                .build();

        /// 4. Devolvemos el DTO envuelto en una respuesta HTTP 500
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
