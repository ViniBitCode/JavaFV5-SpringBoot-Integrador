package ejercicios4.__springboot_ejercicio3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle;

    @ManyToOne(fetch =  FetchType.LAZY) // Muchos detalles a una sola venta
    @JoinColumn(name = "codigo_venta")
    private Venta venta;

    @ManyToOne(fetch =  FetchType.LAZY) // Muchos detalles relacionados a un solo producto
    @JoinColumn(name = "codigo_producto")
    private Producto producto;
    private Integer cant_producto;
    private Double precio_unitario;

}
