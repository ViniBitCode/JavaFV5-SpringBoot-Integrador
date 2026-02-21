package ejercicios4.__springboot_ejercicio3.service;

import ejercicios4.__springboot_ejercicio3.dto.DetalleVentaDTO;
import ejercicios4.__springboot_ejercicio3.dto.VentaDTO;
import ejercicios4.__springboot_ejercicio3.exception.NotFoundException;
import ejercicios4.__springboot_ejercicio3.mapper.Mapper;
import ejercicios4.__springboot_ejercicio3.model.Cliente;
import ejercicios4.__springboot_ejercicio3.model.DetalleVenta;
import ejercicios4.__springboot_ejercicio3.model.Producto;
import ejercicios4.__springboot_ejercicio3.model.Venta;
import ejercicios4.__springboot_ejercicio3.repository.ClienteRepository;
import ejercicios4.__springboot_ejercicio3.repository.ProductoRepository;
import ejercicios4.__springboot_ejercicio3.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private VentaRepository ventaRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @Override
    public List<VentaDTO> getVentas() {

        List<Venta> ventas = ventaRepo.findAll();
        List<VentaDTO> ventasDto = new ArrayList<>();

        // Declaro fuera para que no se instancie varias veces en el for
        VentaDTO ventaDto;

        for(Venta venta : ventas){
            ventaDto = Mapper.toDTO(venta);
            ventasDto.add(ventaDto);
        }

        return ventasDto;

    }

    @Override
    public VentaDTO createVenta(VentaDTO ventaDto) {

        // Valido lo que deberia haber en el DTO que paso por parametro
        if(ventaDto == null) throw new RuntimeException("VentaDTO es nulo");
        if(ventaDto.getId_cliente() == null) throw new RuntimeException("No indico el cliente");
        if(ventaDto.getDetalle() == null || ventaDto.getDetalle().isEmpty()) throw new RuntimeException("No se indicaron productos");

        // Busco al Cliente
        Cliente cliente = clienteRepo.findById(ventaDto.getId_cliente()).orElse(null);
        if(cliente == null) throw new NotFoundException("Cliente no encontrado en la base de datos");

        // Creo la Venta
        Venta venta = new Venta();
        venta.setFecha_venta(ventaDto.getFecha_venta());
        venta.setCliente(cliente);
        venta.setTotal(ventaDto.getTotal());

        // Agrego el detalle (o sea, todos los productos)
        List<DetalleVenta> lista_detallesVenta = new ArrayList<>();

        for(DetalleVentaDTO detalleDto : ventaDto.getDetalle()) {
            Producto producto = productoRepo.findByNombre(detalleDto.getNombre_producto()).orElse(null);
            if(producto == null) throw new RuntimeException("Producto no encontrado | Nombre: " + detalleDto.getNombre_producto());

            // Si el Producto existe, ahora creo el DetalleVenta
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProducto(producto);
            detalleVenta.setVenta(venta);
            detalleVenta.setPrecio_unitario(detalleDto.getPrecio_unitario());
            detalleVenta.setCant_producto(detalleDto.getCant_producto());
            lista_detallesVenta.add(detalleVenta);
        }

        // Le asigno a la Venta la lista de detalles
        venta.setDetalle(lista_detallesVenta);


        // Finalizo guardandola en la BBDD
        return Mapper.toDTO(ventaRepo.save(venta));

    }

    @Override
    public VentaDTO updateVenta(Long id, VentaDTO ventaDto) {
        // Primero busco la venta para actualizarla
        Venta venta = ventaRepo.findById(id).orElse(null);
        if(venta == null) throw new RuntimeException("Venta no encontrada para la edicion");

        // Agrego validaciones para que no entren campos vacios
        if(ventaDto.getFecha_venta() != null) {
            venta.setFecha_venta(ventaDto.getFecha_venta());
        }

        if(ventaDto.getTotal() != null) {
            venta.setTotal(ventaDto.getTotal());
        }

        if(ventaDto.getId_cliente() != null) {
            Cliente cliente = clienteRepo.findById(ventaDto.getId_cliente()).orElse(null);
            if(cliente == null) throw new NotFoundException("Sucursal no encontrada para editar la venta");
            venta.setCliente(cliente);
        }

        return Mapper.toDTO(ventaRepo.save(venta));

    }

    @Override
    public void deleteVenta(Long id) {
        if (!ventaRepo.existsById(id)) {
            throw new NotFoundException("Venta no encontrada para eliminar");
        }

        ventaRepo.deleteById(id);

    }
}
