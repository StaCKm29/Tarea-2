package org.tarea2;

import java.time.Instant;

/**
 * Clase que representa a un empleado
 */
public class Empleado implements Invitable{
    private String id;
    private String nombre;
    private String apellidos;
    private String correo;

    /**
     * Constructor de la clase Empleado
     * @param id Identificador del empleado
     * @param nombre Nombre del empleado
     * @param apellidos Apellidos del empleado
     * @param correo Correo del empleado
     */
    public Empleado(String id, String nombre, String apellidos, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    /**
     * Método que retorna el identificador del empleado
     * @return Identificador del empleado
     */
    public String getId() {
        return id;
    }
    /**
     * Método que retorna el nombre del empleado
     * @return Nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que retorna los apellidos del empleado
     * @return Apellidos del empleado
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Método que retorna el correo del empleado
     * @return Correo del empleado
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Método que invita al empleado a una reunion
     * @param hora Hora a la que se invita al empleado
     */
    @Override
    public void invitar(String hora) {
        System.out.println("Invitando a " + nombre + " " + apellidos + " a las " + hora + " al evento.");
    }
    /**
     * Método que retorna los datos del empleado
     * @return Nombre completo del empleado
     */
    @Override
    public String toString() {
        return "Empleado: " + nombre + " " + apellidos + " (" + id + ")" + " - " + correo;
    }
}
