package org.tarea2;

/**
 * Excepción para cuando el empleado es null.
 */
public class EmpleadoNullException extends Exception{
    public EmpleadoNullException(String message) {
        super(message);
    }
}
