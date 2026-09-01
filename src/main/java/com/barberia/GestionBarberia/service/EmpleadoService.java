package com.barberia.GestionBarberia.service;

import com.barberia.GestionBarberia.DTO.EmpleadoRequestDTO;
import com.barberia.GestionBarberia.DTO.EmpleadoResponseDTO;
import com.barberia.GestionBarberia.exception.RecursoNoEncontradoException;
import com.barberia.GestionBarberia.mapper.EmpleadoMapper;
import com.barberia.GestionBarberia.model.Empleado;
import com.barberia.GestionBarberia.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService implements IEmpleadoService{

    public final EmpleadoRepository empleadoRepo;

    @Override
    public EmpleadoResponseDTO crearEmpleado(EmpleadoRequestDTO dto) {
        Empleado empleadoEntity = EmpleadoMapper.toEntity(dto);

        Empleado empleadoGuardado = empleadoRepo.save(empleadoEntity);

        return EmpleadoMapper.toDTO(empleadoGuardado);
    }

    @Override
    public EmpleadoResponseDTO buscarPorID(Long id) {
        Empleado empleadoEncontrado = empleadoRepo.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("No se encontró el id: " + id));

        return EmpleadoMapper.toDTO(empleadoEncontrado);
    }

    @Override
    public void eliminarPorID(Long id) {
        if(!empleadoRepo.existsById(id)){
            throw new RecursoNoEncontradoException("No se encontró el id: " + id);
        }
        empleadoRepo.deleteById(id);

    }

    @Override
    public List<EmpleadoResponseDTO> listarTodosLosEmpleados() {
        return empleadoRepo.findAll().stream().map(EmpleadoMapper::toDTO).toList();
    }

    @Override
    public EmpleadoResponseDTO actualizarEmpleado(Long id, EmpleadoRequestDTO empleadoDto) {
        Empleado empleadoEncontrado = empleadoRepo.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("No se encontró el id: " + id) );
        empleadoEncontrado.setNombre(empleadoDto.getNombre());
        empleadoEncontrado.setApellido(empleadoDto.getApellido());
        empleadoEncontrado.setUsername(empleadoDto.getUsername());
        empleadoEncontrado.setPassword(empleadoDto.getPassword());
        empleadoEncontrado.setTelefono(empleadoDto.getTelefono());
        empleadoEncontrado.setEmail(empleadoDto.getEmail());
        empleadoEncontrado.setFechaNacimiento(empleadoDto.getFechaNacimiento());
        empleadoEncontrado.setRol(empleadoDto.getRol());
        empleadoEncontrado.setEspecialidad(empleadoDto.getEspecialidad());
        empleadoEncontrado.setFechaContratacion(empleadoDto.getFechaContratacion());
        empleadoEncontrado.setPorcentajeComision(empleadoDto.getPorcentajeComision());
        empleadoEncontrado.setActivo(empleadoDto.getActivo());

        return EmpleadoMapper.toDTO(empleadoRepo.save(empleadoEncontrado));


    }
}
