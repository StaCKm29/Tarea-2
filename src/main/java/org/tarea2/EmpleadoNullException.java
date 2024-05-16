package org.tarea2;

/**
 * Excepción para cuando el empleado es null.
 */
public class EmpleadoNullException extends Exception{
    /**
     * Constructor de la excepción.
     * @param message Mensaje que se mostrará en la excepción.
     */
    public EmpleadoNullException(String message) {
        super(message);
    }
}
