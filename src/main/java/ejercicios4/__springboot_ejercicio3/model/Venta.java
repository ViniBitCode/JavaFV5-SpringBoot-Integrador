package ejercicios4.__springboot_ejercicio3.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;

    @Basic
    private LocalDate fecha_venta;
    private Double total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetalleVenta> detalle = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_cliente_fk", referencedColumnName = "id_cliente")
    private Cliente cliente;
}
