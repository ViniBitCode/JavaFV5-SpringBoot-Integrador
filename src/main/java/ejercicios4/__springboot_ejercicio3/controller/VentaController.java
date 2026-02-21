package ejercicios4.__springboot_ejercicio3.controller;

import ejercicios4.__springboot_ejercicio3.dto.VentaDTO;
import ejercicios4.__springboot_ejercicio3.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

   @Autowired
   private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDTO>> getVentas() {

        return ResponseEntity.ok(ventaService.getVentas());

    }

    @PostMapping
    public ResponseEntity<VentaDTO> createVenta(@RequestBody VentaDTO ventaDto) {

        VentaDTO venta_creada = ventaService.createVenta(ventaDto);

        return ResponseEntity.created(URI.create(String.valueOf(venta_creada.getCodigo_venta()))).body(venta_creada);

    }


    @PutMapping("/{id_venta}")
    public ResponseEntity<VentaDTO> putVenta(@PathVariable Long id_venta, @RequestBody VentaDTO ventaDto){

        return ResponseEntity.ok(ventaService.updateVenta(id_venta, ventaDto));

    }

    @DeleteMapping("/{id_venta}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id_venta) {

        ventaService.deleteVenta(id_venta);

        return ResponseEntity.noContent().build();

    }


}
