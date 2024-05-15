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

    public Invitacion() {
        this.hora = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.tiempoFormateado = formatter.format(hora.atZone(ZoneId.systemDefault()));
    }
    /**
     * Metodo que envia una invitación a un invitado.
     * @param invitado Cualuier clase que implemente la interfaz Invitable.
     */
    public void enviarInvitacion(Invitable invitado) {
        invitado.invitar(tiempoFormateado);
    }
    
}
