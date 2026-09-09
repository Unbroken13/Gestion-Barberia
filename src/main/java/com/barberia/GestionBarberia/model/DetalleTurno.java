package com.barberia.GestionBarberia.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="detalles_turno")
public class DetalleTurno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación hacia el Turno (Cabecera)
    @ManyToOne
    @JoinColumn(name = "turno_id", nullable = false)
    private Turno turno;

    // Relación hacia el Servicio (Catálogo)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Column(nullable = false)
    private BigDecimal precioCobrado;

    @Column(nullable = false)
    private Integer duracionMinutos;

    private LocalDateTime horaInicio;

    private LocalDateTime horaFin;
}
