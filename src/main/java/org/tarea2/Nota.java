package org.tarea2;

/**
 * Clase que representa una nota.
 */
public class Nota {
    private String contenido;

    /**
     * Constructor de la clase Nota.
     * @param contenido Mensaje de la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el mensaje de la nota.
     * @return mensaje de la nota.
     */
    public String getMensaje() {
        return contenido;
    }
}
