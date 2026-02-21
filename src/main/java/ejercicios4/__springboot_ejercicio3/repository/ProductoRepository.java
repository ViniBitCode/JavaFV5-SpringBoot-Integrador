package ejercicios4.__springboot_ejercicio3.repository;

import ejercicios4.__springboot_ejercicio3.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Buscar prodcuto por nombre
    Optional<Producto> findByNombre(String nombre);

}
