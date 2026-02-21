package ejercicios4.__springboot_ejercicio3.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVentaDTO {

    private Long id_detalle;
    private String nombre_producto;
    private Integer cant_producto;
    private Double precio_unitario;
    private Double subtotal;


}
