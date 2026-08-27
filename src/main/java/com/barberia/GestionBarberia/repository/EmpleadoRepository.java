package com.barberia.GestionBarberia.repository;

import com.barberia.GestionBarberia.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, Long> {
}
