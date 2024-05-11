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
    private Instant horaInicio = null;
    private Instant horaFin;
    private Duration duracionReal;
    private TipoReunion tipoReunion;
    private Empleado organizador;
    private int totalAsistentes = 0;
    private float porcentajeAsistencia;
    private List <Empleado> listaInvitados;
    private List <Empleado> empleadosAsistentes;
    private List <Empleado> empleadosAtrasados;
    private List <Empleado> empleadosAusentes;
    private List <Nota> almacenNotas;
    private List <Asistencia> totalAsistencias;
    private List <Retraso> retrasos;


    public Reunion(int tipoReunion, Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitados){
        this.tipoReunion = TipoReunion.values()[tipoReunion];
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.listaInvitados = listaInvitados;
        this.organizador = listaInvitados.getFirst();
        this.almacenNotas = new ArrayList<>();
        this.totalAsistencias = new ArrayList<>();
        this.empleadosAsistentes = new ArrayList<>();
        this.empleadosAtrasados = new ArrayList<>();
        this.empleadosAusentes = new ArrayList<>();
        this.retrasos = new ArrayList<>();
        this.totalAsistencias = new ArrayList<>();
        Invitacion invitacion = new Invitacion();
        for (Empleado empleado : listaInvitados) {
            invitacion.enviarInvitacion(empleado);
        }
    }

    public List obtenerAsistencias(){
        Empleado em;
        for(Asistencia asistir : totalAsistencias){
            em = asistir.getEmpleado();
            empleadosAsistentes.add(em);
        }
        return empleadosAsistentes;
    }
    public List obtenerAusencias(){
        for (Empleado em : listaInvitados){
            if(listaInvitados.contains(em)){
                if(empleadosAusentes.contains(em)){
                    empleadosAusentes.remove(em);
                }else{
                    empleadosAusentes.add(null);
                }
            } else {
                empleadosAusentes.add(em);
            }
        }
        return empleadosAtrasados;
    }
    public List obtenerRetrasos(){
        Empleado em;
        for(Retraso retraso : retrasos){
            em = retraso.getEmpleado();
            empleadosAtrasados.add(em);
        }
        return empleadosAtrasados;
    }
    public int obtenerTotalAsistencia(){
        return totalAsistentes;
    }
    public float obtenerPorcentajeAsistencia(){
        porcentajeAsistencia = (float) (totalAsistentes/listaInvitados.size())*100;
        return porcentajeAsistencia;
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
    }

    public void empleadoEntrando(Empleado em){
        Instant horallegada = Instant.now();
        Asistencia asistio;
        if(horaInicio == null){
            asistio = new Asistencia(em);
            totalAsistencias.add(asistio);
        } else {
            Instant horaTarde = Instant.now();
            asistio = new Retraso(em, horaTarde);
            totalAsistencias.add(asistio);
            retrasos.add((Retraso) asistio);
        }
        totalAsistentes++;
    }
    public void getNotas(){
        for(Nota notita : almacenNotas){
            notita.getMensaje();
        }
    }
}
