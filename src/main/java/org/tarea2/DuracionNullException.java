package org.tarea2;

/**
 * Excepción para el caso donde la duración del la reunión sea nula.
 */
public class DuracionNullException extends Exception {
    public DuracionNullException(String mensaje) {
        super(mensaje);
    }
}
