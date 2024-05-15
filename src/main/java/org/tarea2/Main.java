package org.tarea2;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws EmpleadoNullException, MensajeNullException, DuracionNullException, IniciarReunionIniciadaException, FinalizarReunionNoIniciadaException {
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


        //Reunión ya finalizada e imprimimos por terminal todos los métodos que tenga la reunión.

        EscribirInforme informe = new EscribirInforme("InformeReunion");
        informe.generarInforme(reunion);
        System.out.println();

        System.out.println("Organizador de la reunión: " + reunion.getOrganizador());
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

        System.out.println("Porcentaje de asistencia a la reunión: " + reunion.obtenerPorcentajeAsistencia()+"%");
        System.out.println();

        System.out.println("Notas de la reunión: " + reunion.getNotas());
        System.out.println();
        System.out.println();



        //OTRA REUNIÓN DISTINTA CON UNA INVITACION A UN DEPARTAMENTO
        System.out.println("REUNION 2");
        System.out.println();
        Empleado em1 = new Empleado("6", "José", "Fuentes", "jfuentes@udec.cl");
        Empleado em2 = new Empleado("7", "Geoffrey", "Hecht", "ghecht@udec.cl");
        Empleado em3 = new Empleado("8", "Pierluigi", "Cerulo", "pcerulo@udec.cl");

        //Creación de un departamento
        Departamento DIICC = new Departamento("DIICC");
        //Agrgando empleados al departamento
        DIICC.addEmpleado(em1);
        DIICC.addEmpleado(em2);
        DIICC.addEmpleado(em3);

        //Invitamos a todo el departamento a la reunion 2
        Reunion reunion2 = new ReunionVirtual(0, fechaActual, horaPrevista, duracionPrevista, DIICC.getEmpleados(), "https://meet.google.com/abc-123-def");

        reunion2.empleadoEntrando(em1);
        reunion2.empleadoEntrando(em2);
        reunion2.empleadoEntrando(em3);
        try {
            reunion2.iniciar();
        } catch (IniciarReunionIniciadaException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Duracion de reunion 2: " + reunion2.calcularTiempoReal());
        /*
        System.out.println("Cantidad de empleados en reunion 2: " + reunion.obtenerTotalAsistencia());
        System.out.println("Empleados que llegaron a tiempo a la reunion 2: ");
        for(Object em : reunion2.obtenerAsistencias())
            System.out.println(em);
        */
    }
}
