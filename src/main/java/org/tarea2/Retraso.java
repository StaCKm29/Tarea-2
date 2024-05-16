package org.tarea2;

import java.time.Duration;
import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant horaLlegada; //Hora en que llegó tarde.
    private Instant horaInicio;

    /**
     * Constructor de la clase Retraso.
     * @param em Empleado que llegó tarde.
     * @param horaInicio Hora de inicio de la reunión.
     */
    public Retraso(Empleado em, Instant horaInicio) {
        super(em);
        this.horaLlegada = Instant.now();
        this.horaInicio = horaInicio;
    }

    /**
     * Método que devuelve el empleado que llegó tarde.
     * @return Empleado que llegó tarde.
     */
    @Override
    public Empleado getEmpleado() {
        return super.getEmpleado();
    }

    /**
     * Método que devuelve el tiempo de retraso.
     * @return Tiempo de retraso desde que inició la reunión.
     */
    public Duration getTiempoAtraso() {
        Duration tiempo = Duration.between(horaInicio, horaLlegada);
        return tiempo;
    }
}
