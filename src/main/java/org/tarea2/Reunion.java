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
    private Asistencia asistencia;


    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitados){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.listaInvitados = listaInvitados;
        this.organizador = listaInvitados.getFirst();
        this.asistencia = new Asistencia(listaInvitados);

        Invitacion invitacion = new Invitacion(horaPrevista);
        for (Empleado empleado : listaInvitados) {
            invitacion.enviarInvitacion(empleado);
        }
    }

    public List obtenerAsistencias(){
        return asistencia.getPresentes();
    }
    public List obtenerAusencias(){
        return asistencia.getAusentes()
    }
    public List obtenerRetrasos(){
        return asistencia.getAtrasados();
    }
    public int obtenerTotalAsistencia(){
    }
    public float obtenerPorcentajeAsistencia(){

    }
    public Duration calcularTiempoReal(){
        duracionReal = Duration.between(horaInicio, horaFin);
        return duracionReal;
    }
    public void nuevaNota(String mensaje){
        Nota nota = new Nota(mensaje);
        almacenNotas.add(nota);
    }
    public void iniciar(){
        horaInicio = Instant.now();
    }
    public void finalizar(){
        horaFin = Instant.now();
        asistencia.encontrarAusetes();
    }

    public void asiste(Empleado juan){
        Instant horallegada = Instant.now();
        asistencia.addAsistente(juan, horaInicio, horallegada);
    }
}
