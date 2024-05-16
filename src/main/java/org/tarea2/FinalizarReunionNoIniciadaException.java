package org.tarea2;

/**
 * Excepción para cuando se utiliza el método finalizar() de reunión antes de haber utilizado el método iniciar().
 */
public class FinalizarReunionNoIniciadaException extends Exception {
    /**
     * Constructor de la excepción.
     * @param mensaje Mensaje que se mostrará en la excepción.
     */
    public FinalizarReunionNoIniciadaException(String mensaje) {
        super(mensaje);
    }
}
