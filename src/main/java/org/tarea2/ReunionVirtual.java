package org.tarea2;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion{
    private String enlace; // URL de la reunión

    /**
     * Constructor de la clase ReunionVirtual
     * @param fecha
     * @param horaPrevista
     * @param duracionPrevista
     * @param enlace
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace){
        super(fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }
}
