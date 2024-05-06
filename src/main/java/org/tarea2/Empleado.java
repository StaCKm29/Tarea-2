package org.tarea2;

import java.time.Instant;

public class Empleado implements Invitable{
    private String id;
    private String nombre;
    private String apellidos;
    private String correo;

    public Empleado(String id, String nombre, String apellidos, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getCorreo() {
        return correo;
    }

    @Override
    public void invitar(Instant hora) {
        System.out.println("Invitando a " + nombre + " " + apellidos + " a las " + hora.toString() + " al evento.");
    }
    @Override
    public String toString() {
        return "Empleado: " + nombre + " " + apellidos + " (" + id + ")";
    }
}
