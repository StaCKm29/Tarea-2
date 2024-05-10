package org.tarea2;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Date fechaActual = new Date(2024-1900, 4,10);
        // Crear un LocalDateTime con la hora 13:00
        LocalDateTime hora = LocalDateTime.of(2024, 5, 10, 13, 0); // Año, mes, día, hora, minuto

        // Convertir LocalDateTime a Instant
        Instant horaPrevista = hora.toInstant(ZoneOffset.UTC);
        Duration duracionPrevista = Duration.ofHours(1).plusMinutes(30);
        List <Empleado> listaInvitados = new ArrayList<>();


        Empleado empleado1 = new Empleado("1", "Juan", "Perez", "jperez@udec.cl");
        listaInvitados.add(empleado1);
        Empleado empleado2 = new Empleado("2", "María", "López", "mlopez@udec.cl");
        listaInvitados.add(empleado2);
        Empleado empleado3 = new Empleado("3", "Pedro", "González", "pgonzalez@udec.cl");
        listaInvitados.add(empleado3);
        Empleado empleado4 = new Empleado("4", "Ana", "Martínez", "amartinez@udec.cl");
        listaInvitados.add(empleado4);
        Empleado empleado5 = new Empleado("5", "Carlos", "Rodríguez", "crodriguez@udec.cl");
        listaInvitados.add(empleado5);
        Empleado empleado6 = new Empleado("6", "Laura", "Sánchez", "lsanchez@udec.cl");
        listaInvitados.add(empleado6);
        Empleado empleado7 = new Empleado("7", "Diego", "Gómez", "dgomez@udec.cl");
        listaInvitados.add(empleado7);
        Empleado empleado8 = new Empleado("8", "Sofía", "Hernández", "shernandez@udec.cl");
        listaInvitados.add(empleado8);
        Empleado empleado9 = new Empleado("9", "Alejandro", "Díaz", "adiaz@udec.cl");
        listaInvitados.add(empleado9);
        Empleado empleado10 = new Empleado("10", "Valentina", "Torres", "vtorres@udec.cl");
        listaInvitados.add(empleado10);

        Reunion R = new ReunionPresencial(1, fechaActual, horaPrevista, duracionPrevista , listaInvitados, "Sala 1");
        R.iniciar();
        R.nuevaNota("Primera nota");
        R.nuevaNota("Segunda nota");
        R.nuevaNota("Tercera nota");
        R.asiste(empleado4);
        R.finalizar();
        System.out.println("Duración real: " + R.calcularTiempoReal());
        System.out.println("Total asistentes: " + R.obtenerTotalAsistencia());
        System.out.println("Total de empleados: " + listaInvitados.size());
        System.out.println("Porcentaje de asistencia: " + R.obtenerPorcentajeAsistencia());
        //hacer el sout de cada empleado
        for(Empleado em : (List <Empleado>) R.obtenerAsistencias()) {
            System.out.println(em); //automatico para el toString
        }
        System.out.println("Asistentes: " + R.obtenerAsistencias());
        System.out.println("Ausentes: " + R.obtenerAusencias());
        System.out.println("Retrasos: " + R.obtenerRetrasos());



    }
}