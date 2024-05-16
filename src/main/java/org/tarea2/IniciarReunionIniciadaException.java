package org.tarea2;

/**
 * Excepción para cuando se desea utilizar el método iniciar de reunión más de una vez.
 */
public class IniciarReunionIniciadaException extends Exception {
    /**
     * Constructor de la excepción.
     * @param mensaje Mensaje que se mostrará en la excepción.
     */
    public IniciarReunionIniciadaException(String mensaje) {
        super(mensaje);
    }
}
