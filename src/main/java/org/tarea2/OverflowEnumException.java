package org.tarea2;

/**
 * Excepción para el caso donde se desborde el enum.
 */
public class OverflowEnumException extends Exception{
    /**
     * Constructor de la excepción.
     * @param message Mensaje que se mostrará en la excepción.
     */
    public OverflowEnumException(String message){
        super(message);
    }
}
