package ejercicios4.__springboot_ejercicio3.repository;

import ejercicios4.__springboot_ejercicio3.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
