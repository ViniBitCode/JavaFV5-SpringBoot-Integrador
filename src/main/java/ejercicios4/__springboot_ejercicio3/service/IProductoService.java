package ejercicios4.__springboot_ejercicio3.service;

import ejercicios4.__springboot_ejercicio3.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> getProductos();

    ProductoDTO createProducto(ProductoDTO productoDto);

    ProductoDTO updateProducto(Long id, ProductoDTO productoDto);

    void deleteProducto(Long id);


}
