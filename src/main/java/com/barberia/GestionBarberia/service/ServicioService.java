package com.barberia.GestionBarberia.service;


import com.barberia.GestionBarberia.DTO.ServicioRequestDTO;
import com.barberia.GestionBarberia.DTO.ServicioResponseDTO;
import com.barberia.GestionBarberia.exception.RecursoNoEncontradoException;
import com.barberia.GestionBarberia.mapper.ServicioMapper;
import com.barberia.GestionBarberia.model.Servicio;
import com.barberia.GestionBarberia.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 2. Genera el constructor para inyectar los atributos 'final'
public class ServicioService implements IServicioService{

    private final ServicioRepository serviRepo;

    @Override
    public ServicioResponseDTO crearServicio(ServicioRequestDTO dto){
        // 1. Usamos nuestra clase estática para traducir al modelo de Base de Datos
        Servicio servicioEntity = ServicioMapper.toEntity(dto);

        // 2. Guardamos en MySQL (se autogenera el ID)
        Servicio servicioGuardado = serviRepo.save(servicioEntity);

        // 3. Volvemos a traducir para devolver el DTO al cliente
        return ServicioMapper.toDTO(servicioGuardado);


    }

    @Override
    public ServicioResponseDTO buscarPorID(Long id) {

        // 1 y 2: Buscamos pasándole el Long directamente, y si no existe, lanzamos la excepción
        Servicio servicioEncontrado = serviRepo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el ID."));
        // 3: Si pasó la línea anterior, significa que sí existe.
        // Usamos nuestro Mapper estático para convertir la Entidad en DTO y retornarla.

        return ServicioMapper.toDTO(servicioEncontrado);

    }

    @Override
    public void eliminarPorID(Long id) {
        // 1. Preguntamos si existe (existsById devuelve un boolean).
        // El símbolo "!" significa "NO". Entonces leemos: "Si NO existe el servicio..."
        if (!serviRepo.existsById(id)){
            throw  new RecursoNoEncontradoException("No se encontró el Servicio con el ID " + id);
        }
        // 3. Si Java superó el if anterior, significa que sí existe. Procedemos a borrarlo.
        serviRepo.deleteById(id);
    }

    @Override
    public List<ServicioResponseDTO> listarTodosLosServicios() {
        return serviRepo.findAll().stream().map(ServicioMapper::toDTO).toList();
    }

    @Override
    public ServicioResponseDTO actualizarServicio(Long id, ServicioRequestDTO servicioDTO) {
        //buscamos si existe mi servicio
        Servicio serviEncontrado = serviRepo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Servicio no encontrado"));

        //Si el ID se encontro, modificamos (settear) los datos:
        serviEncontrado.setNombre(servicioDTO.getNombre());
        serviEncontrado.setPrecio(servicioDTO.getPrecio());
        serviEncontrado.setDuracion(servicioDTO.getDuracion());
        serviEncontrado.setDescripcion(servicioDTO.getDescripcion());


        return ServicioMapper.toDTO(serviRepo.save(serviEncontrado));
    }


}

