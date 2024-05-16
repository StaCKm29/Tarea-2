package org.tarea2;

/**
 * Excepción para el caso en que un empleado no invitado quiera entrar a una reunión.
 */
public class EmpleadoNoInvitadoException extends Exception{
    /**
     * Constructor de la excepción.
     * @param message Mensaje que se mostrará en la excepción.
     */
    public EmpleadoNoInvitadoException(String message) {
        super(message);
    }
}
