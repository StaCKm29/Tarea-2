package org.tarea2;

import java.time.Instant;

/**
 * Clase que representa una invitación a un evento.
 */
public class Invitacion {
    private Instant hora;

    public Invitacion() {
        this.hora = Instant.now();
    }
    /**
     * Metodo que envia una invitación a un invitado.
     * @param invitado Invitable a invitar.
     */
    public void enviarInvitacion(Invitable invitado) {
        invitado.invitar(hora);
    }
    
}
