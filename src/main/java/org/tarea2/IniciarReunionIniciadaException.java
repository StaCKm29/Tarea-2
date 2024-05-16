package org.tarea2;

/**
 * Excepción para cuando se desea utilizar el método iniciar de reunión más de una vez.
 */
public class IniciarReunionIniciadaException extends Exception {
    public IniciarReunionIniciadaException(String mensaje) {
        super(mensaje);
    }
}
