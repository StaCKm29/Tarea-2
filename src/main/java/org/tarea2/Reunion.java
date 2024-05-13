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
    private List <String> mensajes;

    public Reunion(Integer tipoReunion, Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitados){
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
        for (Asistencia as : totalAsistencias){
            empleadosAsistentes.add(as.getEmpleado());
        }
        return empleadosAsistentes;
    }
    public List obtenerAusencias() {
        for (Empleado empleado : listaInvitados) {
            boolean asistio = false;
            for (Asistencia asistencia : totalAsistencias) {
                if (asistencia.getEmpleado().equals(empleado)) {
                    if(empleadosAusentes.contains(empleado)){
                        empleadosAusentes.remove(empleado);
                    }
                    asistio = true;
                    break;
                }
            }
            if (!asistio) {
                empleadosAusentes.add(empleado);
            }
        }
        return empleadosAusentes;
    }

    public List obtenerRetrasos(){
        for(Retraso retraso : retrasos){
            empleadosAtrasados.add(retraso.getEmpleado());
        }
        return empleadosAtrasados;
    }
    public int obtenerTotalAsistencia(){
        return totalAsistentes;
    }
    public float obtenerPorcentajeAsistencia(){
        porcentajeAsistencia = ((float)totalAsistentes/listaInvitados.size())*100;
        String porcentajeString = String.valueOf(porcentajeAsistencia).replace(',', '.');
        porcentajeAsistencia = Float.parseFloat(porcentajeString);
        return porcentajeAsistencia;
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

    public void empleadoEntrando(Empleado em) throws EmpleadoNullException{
        if(em == null){
            throw new EmpleadoNullException("El empleado no puede ser nulo");
        }else {
            Asistencia asistio;
            if (horaInicio == null) {
                asistio = new Asistencia(em);
                totalAsistencias.add(asistio);
            } else {
                Instant horaTarde = Instant.now();
                asistio = new Retraso(em, horaInicio, horaTarde);
                totalAsistencias.add(asistio);
                retrasos.add((Retraso) asistio);
            }
            totalAsistentes++;
        }
    }

    public void nuevaNota(String mensaje){
        Nota nota = new Nota(mensaje);
        almacenNotas.add(nota);
    }

    public String getNotas(){
        mensajes = new ArrayList<>();
        for(Nota notita : almacenNotas){
             mensajes.add(notita.getMensaje());
        }
        return mensajes.toString();
    }

    public Date getFecha(){
        return fecha;
    }
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    public Instant getHoraInicio(){
        return horaInicio;
    }

    public Instant getHoraFin(){
        return horaFin;
    }

    public Duration getDuracionReal(){
        return duracionReal;
    }

    public TipoReunion getTipoReunion(){
        return tipoReunion;
    }

    public abstract String getSalaEnlace();
}
