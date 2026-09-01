package com.barberia.GestionBarberia.service;

import com.barberia.GestionBarberia.DTO.CustomerRequestDTO;
import com.barberia.GestionBarberia.DTO.CustomerResponseDTO;
import com.barberia.GestionBarberia.exception.RecursoNoEncontradoException;
import com.barberia.GestionBarberia.mapper.CustomerMapper;
import com.barberia.GestionBarberia.model.Customer;
import com.barberia.GestionBarberia.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepo;

    @Override
    public CustomerResponseDTO crearCustomer(CustomerRequestDTO dto) {
        // 1. Usamos nuestra clase estática para traducir al modelo de Base de Datos
        Customer customerEntity = CustomerMapper.toEntity(dto);

        // 2. Guardamos en MySQL (se autogenera el ID)
        Customer customerGuardado = customerRepo.save(customerEntity);

        // 3. Volvemos a traducir para devolver el DTO al cliente
        return CustomerMapper.toDTO(customerGuardado);
    }

    @Override
    public CustomerResponseDTO buscarPorID(Long id) {
        // 1 y 2: Buscamos pasándole el Long directamente, y si no existe, lanzamos la excepción
        Customer customerEncontrado = customerRepo.findById(id)
                .orElseThrow(()-> new  RecursoNoEncontradoException("No se encontró el ID: "+ id));

        // 3: Si pasó la línea anterior, significa que sí existe.
        // Usamos nuestro Mapper estático para convertir la Entidad en DTO y retornarla.
        return CustomerMapper.toDTO(customerEncontrado);
    }

    @Override
    public void eliminarPorID(Long id) {
        // 1. Preguntamos si existe (existsById devuelve un boolean).
        // El símbolo "!" significa "NO". Entonces leemos: "Si NO existe el servicio..."
        if(!customerRepo.existsById(id)){
            throw new RecursoNoEncontradoException("No se encontró el ID: "+ id);
        }
        // 3. Si Java superó el if anterior, significa que sí existe. Procedemos a borrarlo.
        customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerResponseDTO> listarTodosLosCustomer() {
        return customerRepo.findAll().stream().map(CustomerMapper::toDTO).toList();
    }

    @Override
    public CustomerResponseDTO actualizarCustomer(Long id, CustomerRequestDTO customerDTO) {
        //buscamos si existe mi customer
        Customer customerEncontrado = customerRepo.findById(id)
                .orElseThrow(()-> new  RecursoNoEncontradoException("No se encontró el ID: "+ id));
        //Si el ID se encontro, modificamos (settear) los datos:
        customerEncontrado.setNombre(customerDTO.getNombre());
        customerEncontrado.setApellido(customerDTO.getApellido());
        customerEncontrado.setPassword(customerDTO.getPassword());
        customerEncontrado.setTelefono(customerDTO.getTelefono());
        customerEncontrado.setEmail(customerDTO.getEmail());
        customerEncontrado.setFechaNacimiento(customerDTO.getFechaNacimiento());

        return CustomerMapper.toDTO(customerRepo.save(customerEncontrado));



    }
}
