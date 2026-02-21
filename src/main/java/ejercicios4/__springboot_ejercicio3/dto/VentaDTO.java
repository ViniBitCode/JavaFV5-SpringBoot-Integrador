package ejercicios4.__springboot_ejercicio3.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {

    // Datos de la Venta
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;

    // Datos del Cliente
    private Long id_cliente;

    // Datos de Detalle
    private List<DetalleVentaDTO> detalle;
}
