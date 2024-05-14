package org.tarea2;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws EmpleadoNullException, MensajeNullException {
        Date fechaActual = new Date(2024-1900, 5, 10, 10, 0);
        // Crear un LocalDateTime con la hora 13:00
        LocalDateTime hora = LocalDateTime.of(2024, 5, 14, 13, 0); // Año, mes, día, hora, minuto
        // Convertir LocalDateTime a Instant
        Instant horaPrevista = hora.toInstant(ZoneOffset.UTC);
        // Duracion aproximada de la reunión
        Duration duracionPrevista = Duration.ofHours(1).plusMinutes(30);

        // Crear una lista de empleados los cuales serán invitados a la reunión
        List<Empleado> listaInvitados = new ArrayList<>();
        Empleado empleado1 = new Empleado("1", "Juan", "Perez", "jperez@udec.cl");
        listaInvitados.add(empleado1);
        Empleado empleado2 = new Empleado("2", "María", "López", "mlopez@udec.cl");
        listaInvitados.add(empleado2);
        Empleado empleado3 = new Empleado("3", "Pedro", "González", "pgonzalez@udec.cl");
        listaInvitados.add(empleado3);
        Empleado empleado4 = new Empleado("4", "Ana", "Martínez", "amartinez@udec.cl");
        listaInvitados.add(empleado4);
        Empleado empleado5 = new Empleado("5", "Luis", "Rodríguez", "lrodriguez@udec.cl");
        listaInvitados.add(empleado5);

        Reunion reunion = new ReunionPresencial(2, fechaActual, horaPrevista, duracionPrevista, listaInvitados, "Sala 1");

        //Entrando un empleado a la reunión antes de iniciarse
        reunion.empleadoEntrando(empleado1);

        reunion.iniciar();
        //Agregando notas a la reunión
        reunion.nuevaNota("Nota 1");
        reunion.nuevaNota("Nota 2");
        reunion.nuevaNota("Nota 3");

        //Empleados atrasados entrando a la reunión
        reunion.empleadoEntrando(empleado2);
        reunion.empleadoEntrando(empleado3);

        //Creamos una reunion simulada de 10 segundos
        try {
            TimeUnit.SECONDS.sleep(10); // Retraso de 10 segundos
        } catch (InterruptedException e) {
            // Manejar la interrupción
        }

        reunion.finalizar();
        System.out.println();

        EscribirInforme informe = new EscribirInforme("InformeReunion");
        informe.generarInforme(reunion);
        System.out.println();

        //Pasar de tiempo en formato Duration a formato LocalTime
        Duration duracion = reunion.calcularTiempoReal();
        long horas = duracion.toHours();
        long minutos = duracion.toMinutesPart();
        long segundos = duracion.toSecondsPart();
        // Creamos un objeto LocalTime con los componentes obtenidos
        LocalTime tiempo = LocalTime.of((int) horas, (int) minutos, (int) segundos);
        System.out.println("Duración de la reunión: " + tiempo.toString());
        System.out.println();

        System.out.println("Empleados que asistieron a la reunión: ");
        for (Object em : reunion.obtenerAsistencias())
            System.out.println(em);
        System.out.println();

        System.out.println("Empleados que llegaron tarde a la reunión: ");
        for (Object em : reunion.obtenerRetrasos())
            System.out.println(em);
        System.out.println();

        System.out.println("Empleados que no asistieron a la reunión: ");
        for (Object em : reunion.obtenerAusencias())
            System.out.println(em);
        System.out.println();

        System.out.println("Cantidad de empleados que asistieron a la reunión: " + reunion.obtenerTotalAsistencia());
        System.out.println();

        System.out.println("Porcentaje de asistencia a la reunión: " + reunion.obtenerPorcentajeAsistencia());
        System.out.println();

        System.out.println("Notas de la reunión: " + reunion.getNotas());
        System.out.println();

    }
}
