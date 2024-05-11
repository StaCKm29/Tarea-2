package org.tarea2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    private List <Empleado> listaInvitados;
    private Empleado empleado1, empleado2, empleado3, empleado4, empleado5, empleado6, empleado7, empleado8, empleado9, empleado10;
    private Date fechaActual;
    private Reunion reunion;
    @BeforeEach
    void setUp() {
        fechaActual = new Date(2024-1900, 4,10);
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
        empleado3 = new Empleado("3", "Pedro", "González", "pgonzalez@udec.cl");
        listaInvitados.add(empleado3);
        empleado4 = new Empleado("4", "Ana", "Martínez", "amartinez@udec.cl");
        listaInvitados.add(empleado4);
        empleado5 = new Empleado("5", "Carlos", "Rodríguez", "crodriguez@udec.cl");
        listaInvitados.add(empleado5);
        empleado6 = new Empleado("6", "Laura", "Sánchez", "lsanchez@udec.cl");
        listaInvitados.add(empleado6);
        empleado7 = new Empleado("7", "Diego", "Gómez", "dgomez@udec.cl");
        listaInvitados.add(empleado7);
        empleado8 = new Empleado("8", "Sofía", "Hernández", "shernandez@udec.cl");
        listaInvitados.add(empleado8);
        empleado9 = new Empleado("9", "Alejandro", "Díaz", "adiaz@udec.cl");
        listaInvitados.add(empleado9);
        empleado10 = new Empleado("10", "Valentina", "Torres", "vtorres@udec.cl");
        listaInvitados.add(empleado10);
        reunion = new ReunionPresencial(1, fechaActual, horaPrevista, duracionPrevista , listaInvitados, "Sala 1");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test para obtener asistencias")
    void obtenerAsistencias() {
        reunion.empleadoEntrando(empleado1);
        assertEquals("Juan", reunion.obtenerAsistencias().get(0).getEmpleado().getNombre());
        reunion.empleadoEntrando(empleado2);
        reunion.iniciar();
        assertEquals(2, reunion.obtenerAsistencias().size());
    }

    @Test
    void obtenerAusencias() {
    }

    @Test
    void obtenerTotalAsistencia() {
    }

    @Test
    void obtenerPorcentajeAsistencia() {
    }

    @Test
    void calcularTiempoReal() {
    }

    @Test
    void nuevaNota() {
    }

    @Test
    void empleadoEntrando() {
    }

    @Test
    void getNotas() {
    }
}