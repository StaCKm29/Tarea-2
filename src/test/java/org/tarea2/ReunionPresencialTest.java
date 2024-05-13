package org.tarea2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReunionPresencialTest {
    private Reunion reunion;
    private List<Empleado> listaInvitados;
    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;

    @BeforeEach
    void setUp() {
        Date fechaActual = new Date(2024-1900, 4,10);
        // Crear un LocalDateTime con la hora 13:00
        LocalDateTime hora = LocalDateTime.of(2024, 5, 10, 13, 0); // Año, mes, día, hora, minuto

        // Convertir LocalDateTime a Instant
        Instant horaPrevista = hora.toInstant(ZoneOffset.UTC);
        Duration duracionPrevista = Duration.ofHours(1).plusMinutes(30);
        listaInvitados = new ArrayList<>();

        empleado1 = new Empleado("1", "Juan", "Perez", "jperez@udec.cl");
        listaInvitados.add(empleado1);
        empleado2 = new Empleado("2", "María", "López", "mlopez@udec.cl");
        listaInvitados.add(empleado2);
        empleado3 = new Empleado("3", "Pedro", "González", "pgonazles@udec.cl");
        listaInvitados.add(empleado3);

        reunion = new ReunionPresencial(1, fechaActual, horaPrevista, duracionPrevista, listaInvitados, "Sala 1");
    }

    @Test
    @DisplayName("Test para obtener asistencias")
    void obtenerAsistencias() {
        reunion.empleadoEntrando(empleado1);
        reunion.empleadoEntrando(empleado2);
        reunion.iniciar();
        reunion.empleadoEntrando(empleado3);
        assertEquals(3, reunion.obtenerAsistencias().size());
    }

    @Test
    @DisplayName("Test para obtener retrasos")
    void obtenerRetrasos() {
        reunion.empleadoEntrando(empleado3);
        reunion.iniciar();
        reunion.empleadoEntrando(empleado1);
        reunion.empleadoEntrando(empleado2);
        assertEquals(2, reunion.obtenerRetrasos().size());
    }

    @Test
    @DisplayName("Test para obtener ausencias")
    void obtenerAusencias() {
        reunion.empleadoEntrando(empleado1);
        reunion.empleadoEntrando(empleado2);
        reunion.iniciar();
        assertEquals(1, reunion.obtenerAusencias().size());
        reunion.empleadoEntrando(empleado3);
        assertEquals(0, reunion.obtenerAusencias().size());
    }

    @Test
    @DisplayName("Test para obtener un int con el total de asistentes")
    void obtenerTotalAsistencia() {
        reunion.empleadoEntrando(empleado1);
        reunion.empleadoEntrando(empleado2);
        reunion.iniciar();
        assertEquals(2, reunion.obtenerTotalAsistencia());
    }

    @Test
    void obtenerPorcentajeAsistencia() {
        reunion.empleadoEntrando(empleado1);
        reunion.iniciar();
        assertEquals(33.33, reunion.obtenerPorcentajeAsistencia(), 0.01);
    }


    @Test
    @DisplayName("Test para Notas")
    void IONota() {
        reunion.nuevaNota("Primera nota");
        reunion.nuevaNota("Segunda nota");
        reunion.nuevaNota("Tercera nota");

        System.out.println(reunion.getNotas());
    }

}