package com.barberia.GestionBarberia.service;

import com.barberia.GestionBarberia.DTO.TurnoRequestDTO;
import com.barberia.GestionBarberia.DTO.TurnoResponseDTO;
import com.barberia.GestionBarberia.exception.RecursoNoEncontradoException;
import com.barberia.GestionBarberia.mapper.CustomerMapper;
import com.barberia.GestionBarberia.mapper.TurnoMapper;
import com.barberia.GestionBarberia.model.*;
import com.barberia.GestionBarberia.repository.CustomerRepository;
import com.barberia.GestionBarberia.repository.EmpleadoRepository;
import com.barberia.GestionBarberia.repository.ServicioRepository;
import com.barberia.GestionBarberia.repository.TurnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TurnoService implements ITurnoService{

    private final TurnoRepository turnoRepo;
    private final EmpleadoRepository empleadoRepo;
    private final CustomerRepository customerRepo;
    private final ServicioRepository serviRepo;


    @Override
    @Transactional
    public TurnoResponseDTO crearTurno(TurnoRequestDTO dto) {
        // 1. Validar que el Cliente exista
        Customer cliente = customerRepo.findById(dto.getClienteId())
                .orElseThrow( ()-> new RecursoNoEncontradoException("No se encontró el cliente con ID: "+ dto.getClienteId()));
        // 2. Validar que el Barbero exista
        Empleado barbero = empleadoRepo.findById(dto.getEmpleadoId())
                .orElseThrow(()-> new RecursoNoEncontradoException("No se encontró el cliente con ID: " + dto.getEmpleadoId()));

        // TODO: algoritmo de validación de disponibilidad del barbero en el futuro
        // crear: DisponibilidadNoValidaException

        // 3. crear la entidad turno:
        Turno nuevoTurno = Turno.builder()
                .customer(cliente)
                .empleado(barbero)
                .fechaHora(dto.getFechaHora())
                .estado(EstadoTurno.PENDIENTE) //estado inicial asignado por defecto
                .build();

        // 4. Buscar servicios y armar los detalles congelando el valor
        List<DetalleTurno> detalleTurnos = dto.getServicioIds().stream()
                .map(servicioID -> {
                    //buscar entindad en el catalogo de servicios
                    Servicio servi = serviRepo.findById(servicioID)
                            .orElseThrow(()-> new RecursoNoEncontradoException("No se encontró el servicio con ID: " + servicioID));
                    // Instanciamos el detalle vinculándolo a la cabecera e inyectando los valores actuales
                    return DetalleTurno.builder()
                            .turno(nuevoTurno)
                            .servicio(servi)
                            .precioCobrado(servi.getPrecio())// congela el precio
                            .duracionMinutos(servi.getDuracion()) //congela la duracin actual
                            .build();

                })
                .collect(Collectors.toList());

        // Asignamos la lista de detalles construida a la cabecera
        nuevoTurno.setDetalleTurnos(detalleTurnos);

        // 5. Persistencia en cascada y retorno
        Turno turnoGuardado = turnoRepo.save(nuevoTurno); //guarda el turno y todos sus detalles

        return TurnoMapper.toDTO(turnoGuardado); //traduce la entidad para responder al Front
    }

    @Override
    public TurnoResponseDTO buscarPorID(Long id) {
        // 1 y 2: Buscamos pasándole el Long directamente, y si no existe, lanzamos la excepción
        Turno turnoEncontrado = turnoRepo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el turno con id:" + id));

        // 3: Si pasó la línea anterior, significa que sí existe.
        // Usamos nuestro Mapper estático para convertir la Entidad en DTO y retornarla.
        return TurnoMapper.toDTO(turnoEncontrado);
    }

    @Override
    public List<TurnoResponseDTO> listarTurnos() {
        return turnoRepo.findAll().stream().map(TurnoMapper::toDTO).toList();
    }

    @Override
    public TurnoResponseDTO actualizarEstadoTurno(Long id, EstadoTurno estadoNuevo) {
        return null;
    }
}
