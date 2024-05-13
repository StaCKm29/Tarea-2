package org.tarea2;

import java.time.Duration;
import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant horaLlegada;
    private Instant horaInicio;

    public Retraso(Empleado em, Instant horaInicio, Instant horaLlegada) {
        super(em);
        this.horaLlegada = Instant.now();
        this.horaInicio = horaInicio;
    }

    @Override
    public Empleado getEmpleado() {
        return super.getEmpleado();
    }
    public Duration getTiempoAtraso() {
        Duration tiempo = Duration.between(horaInicio, horaLlegada);
        return tiempo;
    }
}
