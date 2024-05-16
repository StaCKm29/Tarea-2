package org.tarea2;

/**
 * Excepción para el caso donde el mensaje sea nulo.
 */
public class MensajeNullException extends Exception{
    /**
     * Constructor de la excepción.
     * @param mensaje Mensaje que se mostrará en la excepción.
     */
    public MensajeNullException(String mensaje){
        super(mensaje);
    }
}
