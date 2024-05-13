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

    /**
     * Constructor de la clase Reunion
     * @param tipoReunion Tipo de la reunión
     * @param fecha Fecha de la reunión
     * @param horaPrevista Hora prevista de la reunión
     * @param duracionPrevista Duración prevista de la reunión
     * @param listaInvitados Lista de empleados invitados a la reunión
     */
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

    /**
     * Métdodo que retorna los empleados que asistieron a la reunión
     * @return Lista de empleados asistentes
     */
    public List obtenerAsistencias(){
        for (Asistencia as : totalAsistencias){
            empleadosAsistentes.add(as.getEmpleado());
        }
        return empleadosAsistentes;
    }
    /**
     * Método que retorna los empleados que no asistieron a la reunión
     * @return Lista de empleados ausentes
     */
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

    /**
     * Método que retorna los empleados que llegaron tarde a la reunión
     * @return Lista de empleados atrasados
     */
    public List obtenerRetrasos(){
        for(Retraso retraso : retrasos){
            empleadosAtrasados.add(retraso.getEmpleado());
        }
        return empleadosAtrasados;
    }

    /**
     * Método que retorna el total de asistentes a la reunión
     * @return Total de asistentes
     */
    public int obtenerTotalAsistencia(){
        return totalAsistentes;
    }

    /**
     * Método que retorna el porcentaje de asistencia a la reunión
     * @return Porcentaje de asistencia
     */
    public float obtenerPorcentajeAsistencia(){
        porcentajeAsistencia = ((float)totalAsistentes/listaInvitados.size())*100;
        String porcentajeString = String.valueOf(porcentajeAsistencia).replace(',', '.');
        porcentajeAsistencia = Float.parseFloat(porcentajeString);
        return porcentajeAsistencia;
    }

    /**
     * Método que calcula la duración real de la reunión
     * @return Duración real de la reunión
     */
    public Duration calcularTiempoReal(){
        duracionReal = Duration.between(horaInicio, horaFin);
        return duracionReal;
    }

    /**
     * Método que inicia la reunión
     */
    public void iniciar(){
        horaInicio = Instant.now();
    }

    /**
     * Método que finaliza la reunión
     */
    public void finalizar(){
        horaFin = Instant.now();
    }

    /**
     * Método que se usa para representar que un empleado ha entrado a la reunión
     * @param em Empleado que entra a la reunión
     */
    public void empleadoEntrando(Empleado em){
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

    /**
     * Método que se una para agregar una nota a la reunión
     * @param mensaje Mensaje de la nota
     */
    public void nuevaNota(String mensaje){
        Nota nota = new Nota(mensaje);
        almacenNotas.add(nota);
    }

    /**
     * Método que retorna las notas de la reunión
     * @return Notas de la reunión
     */
    public String getNotas(){
        mensajes = new ArrayList<>();
        for(Nota notita : almacenNotas){
             mensajes.add(notita.getMensaje());
        }
        return mensajes.toString();
    }


}
