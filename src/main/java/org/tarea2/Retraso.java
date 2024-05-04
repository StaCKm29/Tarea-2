package org.tarea2;

import java.time.Instant;
import java.util.List;

public class Retraso extends Asistencia{
    private Instant hora = Instant.now();
    public Retraso(List empleados) {
        super(empleados);
    }
}
