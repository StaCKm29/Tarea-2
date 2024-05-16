package org.tarea2;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Clase ReunionVirtual que hereda de Reunión.
 */
public class ReunionVirtual extends Reunion{
    private String enlace; // URL de la reunión.

    /**
     * Constructor de la clase ReunionVirtual.
     * @param tipo tipo de reunión (ver enum).
     * @param fecha fecha de la reunión.
     * @param horaPrevista hora aproximada de inicio de la reunión.
     * @param duracionPrevista duración aproximada de la reunión.
     * @param listaInvitado lista de empleados invitados a la reunión.
     * @param enlace enlace de la reunión.
     * @throws OverflowEnumException excepción de tipo de reunión no válido.
     * @throws EmpleadoNullException excepción que se lanza si se invita un Empleado null.
     */
    public ReunionVirtual(int tipo, Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitado, String enlace) throws EmpleadoNullException, OverflowEnumException{
        super(tipo, fecha, horaPrevista, duracionPrevista, listaInvitado);
        this.enlace = enlace;
    }

    /**
     * Método que retorna el enlace de la reunión.
     * @return enlace de la reunión.
     */
    public String getSalaEnlace(){
        return "El enlace de la reunión es: " + enlace;
    }
}
