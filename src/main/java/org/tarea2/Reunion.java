package org.tarea2;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin = Instant.now();

    /**
     * Constructor de la clase Reunion
     * @param fecha
     * @param horaPrevista
     * @param duracionPrevista
     */
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
    }
    
    public abstract List obtenerAsistencias();
    public abstract List obtenerAusencias();
    public abstract List obtenerRetrasos();
    public abstract int obtenerTotalAsistencia();
    public abstract float obtenerPorcentajeAsistencia();
    public abstract float calcularTiempoReal();
    public abstract void iniciar();
    public abstract void finalizar();
}
