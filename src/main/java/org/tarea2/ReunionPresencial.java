package org.tarea2;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion{
    private String sala;

    /**
     * Constructor de la clase ReunionPresencial
     * @param fecha
     * @param horaPrevista
     * @param duracionPrevista
     * @param sala
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }

}
