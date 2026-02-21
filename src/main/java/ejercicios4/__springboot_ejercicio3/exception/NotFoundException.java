package ejercicios4.__springboot_ejercicio3.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensaje) {
        super(mensaje);
    }

}
