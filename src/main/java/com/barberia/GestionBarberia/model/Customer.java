package com.barberia.GestionBarberia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "customers")
public class Customer extends User {

    private Integer puntosFidelidad;

    private String notasPreferidas;

    private Integer abandonoDeTurnos;



}
