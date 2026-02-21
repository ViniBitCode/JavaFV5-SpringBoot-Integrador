package ejercicios4.__springboot_ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_producto;

    @Basic
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
}
