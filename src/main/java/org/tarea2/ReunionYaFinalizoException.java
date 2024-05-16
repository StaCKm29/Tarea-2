package org.tarea2;

/**
 * Excepción para cuando quiere ingresar un empleado cuando la reunión ya finalizó.
 */
public class ReunionYaFinalizoException extends Exception {
    public ReunionYaFinalizoException(String message) {
        super(message);
    }
}
