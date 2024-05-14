package org.tarea2;

/**
 * Clase que representa una nota
 */
public class Nota {
    private String contenido;

    /**
     * Constructor de la clase Nota
     * @param contenido Contenido de la nota
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }
    /**
     * @return Contenido de la nota
     */
    public String getMensaje() {
        return contenido;
    }
}
