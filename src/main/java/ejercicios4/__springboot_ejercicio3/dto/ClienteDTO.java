package ejercicios4.__springboot_ejercicio3.dto;

import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private String nombre;
    private String apellido;
    private String dni;

}
