package ejercicios4.__springboot_ejercicio3.repository;

import ejercicios4.__springboot_ejercicio3.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
