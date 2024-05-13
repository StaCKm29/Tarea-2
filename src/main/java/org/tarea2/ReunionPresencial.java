package org.tarea2;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
/**
 * Clase que representa una reunión presencial
 */
public class ReunionPresencial extends Reunion{
    private String sala;
    /**
     * Constructor de la clase ReunionPresencial
     * @param tipo Tipo de la reunión
     * @param fecha Fecha de la reunión
     * @param horaPrevista Hora prevista de la reunión
     * @param duracionPrevista Duración prevista de la reunión
     * @param listaInvitados Lista de invitados a la reunión
     * @param sala Sala de la reunión
     */
    public ReunionPresencial(int tipo, Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitados, String sala){
        super(tipo, fecha, horaPrevista, duracionPrevista, listaInvitados);
        this.sala = sala;
    }

}
