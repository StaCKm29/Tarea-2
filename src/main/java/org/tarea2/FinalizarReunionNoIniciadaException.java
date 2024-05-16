package org.tarea2;

/**
 * Excepción para cuando se utiliza el método finalizar() de reunión antes de haber utilizado el método iniciar().
 */
public class FinalizarReunionNoIniciadaException extends Exception {
    public FinalizarReunionNoIniciadaException(String mensaje) {
        super(mensaje);
    }
}
