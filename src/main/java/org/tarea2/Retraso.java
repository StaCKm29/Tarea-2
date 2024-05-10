package org.tarea2;

import java.time.Instant;
import java.util.List;

public class Retraso extends Asistencia{
    private Instant hora;
    private Empleado em;
    public Retraso(Empleado em, Instant hora) {
        super(em);
        this.hora = hora;
    }

    @Override
    public Empleado getEmpleado() {
        return super.getEmpleado();
    }
}
