package org.tarea2;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ReunionVirtual extends Reunion{
    private String enlace; // URL de la reunión

    /**
     * Constructor de la clase ReunionVirtual
     * @param fecha
     * @param horaPrevista
     * @param duracionPrevista
     * @param enlace
     */
    public ReunionVirtual(int tipo, Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitado, String enlace) {
        super(tipo, fecha, horaPrevista, duracionPrevista, listaInvitado);
        this.enlace = enlace;
    }

    public String getSalaEnlace(){
        return "El enlace de la reunión es: " + enlace;
    }
}
