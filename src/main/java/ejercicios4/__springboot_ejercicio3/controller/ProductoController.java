package ejercicios4.__springboot_ejercicio3.controller;

import ejercicios4.__springboot_ejercicio3.dto.ProductoDTO;
import ejercicios4.__springboot_ejercicio3.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private PathMatcher pathMatcher;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getProductos(){

        return ResponseEntity.ok(productoService.getProductos());

    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDto){

        ProductoDTO producto_creado= productoService.createProducto(productoDto);

        return ResponseEntity.created(URI.create("/api/productos" + producto_creado.getNombre())).body(producto_creado);

    }

    @PutMapping("/{id_producto}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id_producto, @RequestBody ProductoDTO producto){

        return ResponseEntity.ok(productoService.updateProducto(id_producto, producto));

    }

    @DeleteMapping("/{id_producto}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id_producto) {

        productoService.deleteProducto(id_producto);

        return ResponseEntity.noContent().build();

    }


}
