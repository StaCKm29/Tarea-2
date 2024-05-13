package org.tarea2;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws EmpleadoNullException, MensajeNullException {
        Date fechaActual = new Date(2024-1900, 4,10);
        // Crear un LocalDateTime con la hora 13:00
        LocalDateTime hora = LocalDateTime.of(2024, 5, 10, 13, 0); // Año, mes, día, hora, minuto
        // Convertir LocalDateTime a Instant
        Instant horaPrevista = hora.toInstant(ZoneOffset.UTC);
        Duration duracionPrevista = Duration.ofHours(1).plusMinutes(30);
        List<Empleado> listaInvitados = new ArrayList<>();

        Empleado empleado1 = new Empleado("1", "Juan", "Perez", "j");
        listaInvitados.add(empleado1);
        Empleado empleado2 = new Empleado("2", "María", "López", "m");
        listaInvitados.add(empleado2);
        Reunion reunion = new ReunionPresencial(2, fechaActual, horaPrevista, duracionPrevista, listaInvitados, "Sala 1");
        reunion.empleadoEntrando(empleado1);
        reunion.nuevaNota("Nota 1");
        reunion.nuevaNota("Nota 2");
        reunion.nuevaNota("Nota 3");
        System.out.println(reunion.getNotas());
        System.out.println("Cantidad total de asistentes: "+reunion.obtenerTotalAsistencia());
        reunion.iniciar();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        reunion.empleadoEntrando(empleado2);
        reunion.finalizar();
        EscribirInforme informe = new EscribirInforme("InformeReunion");
        informe.generarInforme(reunion);
    }
}
