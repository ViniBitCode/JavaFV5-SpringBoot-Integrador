package ejercicios4.__springboot_ejercicio3.mapper;

import ejercicios4.__springboot_ejercicio3.dto.ClienteDTO;
import ejercicios4.__springboot_ejercicio3.dto.DetalleVentaDTO;
import ejercicios4.__springboot_ejercicio3.dto.ProductoDTO;
import ejercicios4.__springboot_ejercicio3.dto.VentaDTO;
import ejercicios4.__springboot_ejercicio3.model.Cliente;
import ejercicios4.__springboot_ejercicio3.model.Producto;
import ejercicios4.__springboot_ejercicio3.model.Venta;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    // Mapeo de Cliente a ClienteDTO
    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) return null;
        return ClienteDTO.builder()
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .build();
    }

    // Mapeo de Producto a ProductoDTO
    public static ProductoDTO toDTO(Producto producto){
        if (producto == null) return null;
        return ProductoDTO.builder()
                .nombre(producto.getNombre())
                .marca(producto.getMarca())
                .costo(producto.getCosto())
                .cantidad_disponible((producto.getCantidad_disponible()))
                .build();
    }

    // Mapeo de Venta a VentaDTO
    public static VentaDTO toDTO(Venta venta){
        if(venta == null) return null;

        List<DetalleVentaDTO> detalle = venta.getDetalle().stream().map(detalleVenta ->
                DetalleVentaDTO.builder()
                .id_detalle((detalleVenta.getId_detalle()))
                .nombre_producto(detalleVenta.getProducto().getNombre())
                .cant_producto(detalleVenta.getCant_producto())
                .precio_unitario(detalleVenta.getPrecio_unitario())
                .subtotal(detalleVenta.getPrecio_unitario() * detalleVenta.getCant_producto()).build()
        ).toList();

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .codigo_venta(venta.getCodigo_venta())
                .fecha_venta(venta.getFecha_venta())
                .detalle(detalle)
                .total(total)
                .id_cliente(venta.getCliente().getId_cliente())
                .build();
    }
}