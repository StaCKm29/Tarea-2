package org.tarea2;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ReunionPresencial extends Reunion{
    private String sala;
    private Duration duracionReunion;
    private Instant horaInicio;
    private Instant horaFin;

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
        horaInicio = Instant.now();
    }


    @Override
    public List obtenerAsistencias() {
        return List.of();
    }

    @Override
    public List obtenerAusencias() {
        return List.of();
    }

    @Override
    public List obtenerRetrasos() {
        return List.of();
    }

    @Override
    public int obtenerTotalAsistencia() {
        return 0;
    }

    @Override
    public float obtenerPorcentajeAsistencia() {
        return 0;
    }

    @Override
    public float calcularTiempoReal() {
        duracionReunion = Duration.between(horaInicio, horaFin);
        return 0;
    }

    @Override
    public void iniciar() {

    }

    @Override
    public void finalizar() {

    }
}
