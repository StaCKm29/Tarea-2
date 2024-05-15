package org.tarea2;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una reunión, que será utilizada para gestionar las reuniones de la empresa.
 */
abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio = null;
    private Instant horaFin = null;
    private Duration duracionReal;
    private TipoReunion tipoReunion;
    private Empleado organizador;
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
     * Constructor de la clase Reunion.
     * @param tipoReunion Tipo de reunión.
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista de la reunión.
     * @param duracionPrevista Duración prevista de la reunión.
     * @param listaInvitados Lista de invitados a la reunión.
     * @throws OverflowEnumException Excepción que se lanza si el tipo de reunión no es válido.
     * @throws EmpleadoNullException Excepción que se lanza si se invita un empleado nulo.
     */
    public Reunion(int tipoReunion, Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitados) throws OverflowEnumException, EmpleadoNullException {
        if(tipoReunion < 0 || tipoReunion >= TipoReunion.values().length){
            throw new OverflowEnumException("El tipo de reunión no es válido.");
        }else{
            this.tipoReunion = TipoReunion.values()[tipoReunion];
        }
        //Iniciando parametros de reunión.
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.listaInvitados = listaInvitados;

        // El organizador de la reunión será el primer empleado de la lista de invitados.
        this.organizador = listaInvitados.getFirst();

        this.almacenNotas = new ArrayList<>();

        this.retrasos = new ArrayList<>();
        this.totalAsistencias = new ArrayList<>();
        this.empleadosAsistentes = new ArrayList<>();
        this.empleadosAtrasados = new ArrayList<>();
        this.empleadosAusentes = new ArrayList<>();

        /**
         * Se envía la invitación a los empleados de la lista de invitados.
         */
        Invitacion invitacion = new Invitacion();
        for (Empleado empleado : listaInvitados) {
            invitacion.enviarInvitacion(empleado);
        }
    }

    /**
     * Método que obtiene la lista de asistentes a la reunión.
     * @return Lista de asistentes a la reunión.
     */
    public List<Empleado> obtenerAsistencias(){
        empleadosAsistentes = new ArrayList<>();
        for (Asistencia as : totalAsistencias){
            empleadosAsistentes.add(as.getEmpleado());
        }
        return empleadosAsistentes;
    }

    /**
     * Método que obtiene la lista de ausentes a la reunión.
     * @return Lista de ausentes a la reunión.
     */
    public List<Empleado> obtenerAusencias() {
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
     * Método que obtiene la lista de empleados que llegaron tarde a la reunión.
     * @return Lista de empleados que llegaron tarde a la reunión.
     */
    public List<Empleado> obtenerRetrasos(){
        for(Retraso retraso : retrasos){
            empleadosAtrasados.add(retraso.getEmpleado());
        }
        return empleadosAtrasados;
    }

    /**
     * Método que obtiene la lista de retrasos.
     * @return Lista de retrasos de la reunion.
     */
    public List<Retraso> getEmpleadosHoraRetraso(){
        return retrasos;
    }

    /**
     * Método que obtiene el total de asistentes a la reunión.
     * @return Total de asistentes a la reunión.
     */
    public int obtenerTotalAsistencia(){
        return totalAsistencias.size();
    }

    /**
     * Método que obtiene el porcentaje de asistencia a la reunión.
     * @return Porcentaje de asistencia a la reunión.
     */
    public float obtenerPorcentajeAsistencia(){
        porcentajeAsistencia = ((float)totalAsistencias.size()/listaInvitados.size())*100;
        String porcentajeString = String.valueOf(porcentajeAsistencia).replace(',', '.');
        porcentajeAsistencia = Float.parseFloat(porcentajeString);
        return porcentajeAsistencia;
    }

    /**
     * Método que calcula la duración real de la reunión.
     * @return Duración real de la reunión.
     * @throws DuracionNullException Excepción que se lanza si la reunión no ha sido iniciada o finalizada.
     */
    public Duration calcularTiempoReal() throws DuracionNullException {
        if(horaInicio == null || horaFin == null){
            throw new DuracionNullException("La reunión debe iniciar y finalizar primero. ");
        }else {
            duracionReal = Duration.between(horaInicio, horaFin);
            return duracionReal;
        }
    }

    /**
     * Método que inicia la reunión.
     * @throws IniciarReunionIniciadaException Excepción que se lanza si la reunión ya ha sido iniciada.
     */
    public void iniciar() throws IniciarReunionIniciadaException {
        if(horaInicio != null){
            throw new IniciarReunionIniciadaException("La reunión ya ha sido iniciada.");
        }else{
            horaInicio = Instant.now();
        }
    }

    /**
     * Método que finaliza la reunión.
     * @throws FinalizarReunionNoIniciadaException Excepción que se lanza si la reunión no ha sido iniciada.
     */
    public void finalizar() throws FinalizarReunionNoIniciadaException {
        if(horaInicio == null) {
            throw new FinalizarReunionNoIniciadaException("La reunión no ha sido iniciada.");
        }
        else{
            horaFin = Instant.now();
        }
    }

    /**
     * Método que añade un empleado a la reunión.
     * @param em Empleado a añadir a la reunión.
     * @throws EmpleadoNoInvitadoException Excepción que se lanza si el empleado no ha sido invitado a la reunión.
     * @throws ReunionYaFinalizoException Excepción que se lanza si la reunión ya ha finalizado.
     */
    public void empleadoEntrando(Empleado em) throws EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        if(!listaInvitados.contains(em)){
            throw new EmpleadoNoInvitadoException("El empleado no ha sido invitado a la reunión.");
        } else if (horaFin != null) {
            throw new ReunionYaFinalizoException("La reunión ya finalizó.");
        } else {
            Asistencia asistio;
            if (horaInicio == null) {
                asistio = new Asistencia(em);
                totalAsistencias.add(asistio);
            } else {
                asistio = new Retraso(em, horaInicio);
                totalAsistencias.add(asistio);
                retrasos.add((Retraso) asistio);
            }
        }
    }


    /**
     * Método que añade una nota a la reunión.
     * @param mensaje Mensaje de la nota.
     * @throws MensajeNullException Excepción que se lanza si el mensaje es nulo.
     */
    public void nuevaNota(String mensaje) throws MensajeNullException {
        if(mensaje == null){
            throw new MensajeNullException("El mensaje no puede ser nulo");
        }else {
            Nota nota = new Nota(mensaje);
            almacenNotas.add(nota);
        }
    }

    /**
     * Método que obtiene las notas de la reunión.
     * @return Notas de la reunión.
     */
    public String getNotas(){
        mensajes = new ArrayList<>();
        for(Nota notita : almacenNotas){
             mensajes.add(notita.getMensaje());
        }
        return mensajes.toString();
    }

    /**
     * Método que obtiene la fecha de la reunión.
     * @return Fecha de la reunión.
     */
    public Date getFecha(){
        return fecha;
    }

    /**
     * Método que obtiene la hora prevista de la reunión.
     * @return Hora prevista de la reunión.
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    /**
     * Método que obtiene la hora de inicio de la reunión.
     * @return La hora de inicio de la reunión.
     */
    public Instant getHoraInicio(){
        return horaInicio;
    }

    /**
     * Método que obtiene la hora de fin de la reunión.
     * @return La hora de fin de la reunión.
     */
    public Instant getHoraFin(){
        return horaFin;
    }

    /**
     * Método que obtiene el tipo de reunión.
     * @return Tipo de reunión.
     */
    public TipoReunion getTipoReunion(){
        return tipoReunion;
    }

    /**
     * Método abstracto para obtener la sala/enlace de la reunión ya sea presencial o virtual.
     * @return Sala/enlace de la reunión.
     */
    public abstract String getSalaEnlace();

    /**
     * Método para obtener el organizador de la reunión.
     * @return Organizador de la reunión.
     */
    public Empleado getOrganizador(){
        return organizador;
    }
}
