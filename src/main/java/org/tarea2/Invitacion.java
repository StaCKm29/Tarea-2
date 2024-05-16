package org.tarea2;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una invitación a un evento.
 */
public class Invitacion {
    private Instant hora; //Hora a la que envía la invitación.
    private String tiempoFormateado;
    /**
     * Constructor de la clase Invitacion.
     */
    public Invitacion() {
        this.hora = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.tiempoFormateado = formatter.format(hora.atZone(ZoneId.systemDefault()));
    }
    /**
     * Método que envía una invitación a un invitado.
     * @param invitado Cualquier clase que implemente la interfaz Invitable.
     * @throws EmpleadoNullException Excepción que se lanza si se invita un empleado null.
     */
    public void enviarInvitacion(Invitable invitado) throws EmpleadoNullException{
        if(invitado == null){
            throw new EmpleadoNullException("El empleado es null.");
        }else {
            invitado.invitar(tiempoFormateado);
        }
    }
    
}
