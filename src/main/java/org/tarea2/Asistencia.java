package org.tarea2;

/**
 * Asistencia sirve para representar que un empleado asistió.
 */
public class Asistencia {
    private Empleado em;

    /**
     * Constructor de la clase Asistencia.
     * @param em Es el empleado asignado.
     */
    public Asistencia (Empleado em){
        this.em = em;
    }

    /**
     * El siguiente método devuelve el empleado que ha asistido.
     * @return em Empleado que asistió.
     */
    public Empleado getEmpleado(){
        return em;
    }
}