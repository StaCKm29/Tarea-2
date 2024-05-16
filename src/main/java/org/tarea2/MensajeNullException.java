package org.tarea2;

/**
 * Excepción para el caso donde el mensaje sea nulo.
 */
public class MensajeNullException extends Exception{
    public MensajeNullException(String mensaje){
        super(mensaje);
    }
}
