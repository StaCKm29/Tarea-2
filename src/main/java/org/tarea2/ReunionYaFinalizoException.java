package org.tarea2;

/**
 * Excepción para cuando quiere ingresar un empleado cuando la reunión ya finalizó.
 */
public class ReunionYaFinalizoException extends Exception {
    /**
     * Constructor de la excepción.
     * @param message Mensaje que se mostrará en la excepción.
     */
    public ReunionYaFinalizoException(String message) {
        super(message);
    }
}
