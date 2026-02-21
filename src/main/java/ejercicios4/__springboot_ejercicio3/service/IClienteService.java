package ejercicios4.__springboot_ejercicio3.service;

import ejercicios4.__springboot_ejercicio3.dto.ClienteDTO;

import java.util.List;

interface IClienteService {

    List<ClienteDTO> getClientes();

    ClienteDTO createCliente(ClienteDTO clienteDto);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDto);

    void deleteCliente(Long id);

}
