package org.tarea2;

import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant hora;

    public Retraso(Empleado em, Instant hora) {
        super(em);
        this.hora = hora;
    }

    @Override
    public Empleado getEmpleado() {
        return super.getEmpleado();
    }
}
