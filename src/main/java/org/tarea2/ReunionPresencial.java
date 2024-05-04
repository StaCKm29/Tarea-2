package org.tarea2;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(int tipo, Date fecha, Instant horaPrevista, Duration duracionPrevista, List <Empleado> listaInvitados, String sala){
        super(tipo, fecha, horaPrevista, duracionPrevista, listaInvitados);
        this.sala = sala;
    }

}
