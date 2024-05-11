package org.tarea2;

import java.awt.event.WindowStateListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Asistencia {
    private Empleado em;

    public Asistencia (Empleado em){
        this.em = em;
    }
    public Empleado getEmpleado(){
        return em;
    }
}