package ejercicios4.__springboot_ejercicio3.controller;

import ejercicios4.__springboot_ejercicio3.dto.ClienteDTO;
import ejercicios4.__springboot_ejercicio3.service.ClienteService;
import ejercicios4.__springboot_ejercicio3.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getClientes(){

        return ResponseEntity.ok(clienteService.getClientes());

    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDto) {

        ClienteDTO cliente_creado = clienteService.createCliente(clienteDto);

        return ResponseEntity.created(URI.create("/api/clientes" + cliente_creado.getNombre())).body(cliente_creado);

    }

    @PutMapping("/{id_cliente}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id_cliente, @RequestBody ClienteDTO clienteDto){

        return ResponseEntity.ok(clienteService.updateCliente(id_cliente, clienteDto));

    }

    @DeleteMapping("/{id_cliente}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id_cliente) {

        clienteService.deleteCliente(id_cliente);

        return ResponseEntity.noContent().build();

    }

}
