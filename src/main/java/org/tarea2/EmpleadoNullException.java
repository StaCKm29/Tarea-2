package org.tarea2;

/**
 * Excepción para cuando el empleado es nulo en el método empleadoEntrando en la clase reunion.
 */
public class EmpleadoNullException extends Exception{
    public EmpleadoNullException(String message) {
        super(message);
    }
}
