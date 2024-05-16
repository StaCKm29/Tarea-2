package org.tarea2;

/**
 * Excepción para el caso donde se desborde el enum.
 */
public class OverflowEnumException extends Exception{
    public OverflowEnumException(String message){
        super(message);
    }
}
