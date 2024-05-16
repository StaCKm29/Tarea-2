package org.tarea2;

/**
 * Excepción para el caso donde la duración del la reunión sea nula.
 */
public class DuracionNullException extends Exception {
    /**
     * Constructor de la excepción.
     * @param mensaje Mensaje que se mostrará en la excepción.
     */
    public DuracionNullException(String mensaje) {
        super(mensaje);
    }
}
