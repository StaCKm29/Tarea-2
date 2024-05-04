package org.tarea2;

import java.awt.event.WindowStateListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Asistencia {
    private List<Empleado> empleados;
    private List<Empleado> atrasados;
    private List<Empleado> ausentes;

    public Asistencia(List empleados){
        this.empleados = empleados;
        this.atrasados = new ArrayList<>();
        this.ausentes = new ArrayList<>();
    }

}
