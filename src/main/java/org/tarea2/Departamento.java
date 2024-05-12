package org.tarea2;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;
/**Clase que representa un departamento de la empresa.*/
public class Departamento implements Invitable{
    private String nombre;
    private List <Empleado> empleados = new ArrayList<>();

    /**
     * Constructor de la clase Departamento
     * @param nombre Nombre del departamento
     */
    public Departamento(String nombre){
        this.nombre = nombre;
    }

    /**
     * Método que añade un empleado al departamento.
     * @param empleado Empleado a añadir al departamento.
     */
    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    /**
     * Método que contabiliza la cantidad de empleados en el departamento.
     * @return Cantidad de empleados en el departamento.
     */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**
     * Método que invita a los empleados del departamento a un evento.
     */
    @Override
    public void invitar(String hora) {
        System.out.println("Invitando a los empleados del departamento " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar(hora); 
        }
    }
}
