package ejercicios4.__springboot_ejercicio3.service;

import ejercicios4.__springboot_ejercicio3.dto.ClienteDTO;
import ejercicios4.__springboot_ejercicio3.exception.NotFoundException;
import ejercicios4.__springboot_ejercicio3.mapper.Mapper;
import ejercicios4.__springboot_ejercicio3.model.Cliente;
import ejercicios4.__springboot_ejercicio3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClienteRepository clienteRepo;

    @Override
    public List<ClienteDTO> getClientes() {
        return clienteRepo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDto) {
        Cliente cliente = Cliente.builder()
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .dni(clienteDto.getDni())
                .build();

        return Mapper.toDTO(clienteRepo.save(cliente));
    }

    @Override
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDto) {
        // Veo si existe el Cliente
        Cliente cliente = clienteRepo.findById(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado para editar"));

        // Edito al Cliente
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        return Mapper.toDTO(clienteRepo.save(cliente));

    }

    @Override
    public void deleteCliente(Long id) {
        if(!clienteRepo.existsById(id)){
            throw new NotFoundException("Cliente no encontrado para eliminar");
        }

        clienteRepo.deleteById(id);

    }
}
