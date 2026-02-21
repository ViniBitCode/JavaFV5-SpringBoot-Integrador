package ejercicios4.__springboot_ejercicio3.service;

import ejercicios4.__springboot_ejercicio3.dto.ProductoDTO;
import ejercicios4.__springboot_ejercicio3.exception.NotFoundException;
import ejercicios4.__springboot_ejercicio3.mapper.Mapper;
import ejercicios4.__springboot_ejercicio3.model.Producto;
import ejercicios4.__springboot_ejercicio3.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    ProductoRepository productRepo;

    @Override
    public List<ProductoDTO> getProductos() {
        return productRepo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDto) {
        Producto producto = Producto.builder().nombre(productoDto.getNombre()).marca(productoDto.getMarca()).cantidad_disponible(productoDto.getCantidad_disponible()).costo(productoDto.getCosto()).build();


        return Mapper.toDTO(productRepo.save(producto));
    }

    @Override
    public ProductoDTO updateProducto(Long id, ProductoDTO productoDto) {

        Producto producto = productRepo.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado para editar"));

        producto.setCosto(productoDto.getCosto());
        producto.setNombre(productoDto.getNombre());
        producto.setMarca(productoDto.getMarca());
        producto.setCantidad_disponible(productoDto.getCantidad_disponible());

        return Mapper.toDTO(productRepo.save(producto));


    }

    @Override
    public void deleteProducto(Long id) {
        if (!productRepo.existsById(id)) {
            throw new NotFoundException("Producto no encontrado para eliminar");
        }

        productRepo.deleteById(id);

    }
}
