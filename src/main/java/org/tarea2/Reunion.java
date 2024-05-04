package org.tarea2;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Duration duracionReal;
    private Empleado organizador;
    private List <Empleado> listaInvitados;
    private List <Empleado> listaAsistentes;
    private List <Empleado> listaAusentes;
    private List <Empleado> listaAtrasados;
    private List <Nota> almacenNotas;


    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitados){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.listaInvitados = listaInvitados;
        this.organizador = listaInvitados.getFirst();

        Invitacion invitacion = new Invitacion(horaPrevista);
        for (Empleado empleado : listaInvitados) {
            invitacion.enviarInvitacion(empleado);
        }
    }

    public List obtenerAsistencias(){

    }
    public List obtenerAusencias(){

    }
    public List obtenerRetrasos(){

    }
    public int obtenerTotalAsistencia(){

    }
    public float obtenerPorcentajeAsistencia(){

    }
    public Duration calcularTiempoReal(){
        duracionReal = Duration.between(horaInicio, horaFin);
        return duracionReal;
    }
    public void iniciar(){
        horaInicio = Instant.now();
    }
    public void finalizar(){
        horaFin = Instant.now();
    }
}
