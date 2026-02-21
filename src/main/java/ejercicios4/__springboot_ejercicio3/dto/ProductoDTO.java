package ejercicios4.__springboot_ejercicio3.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;

}
