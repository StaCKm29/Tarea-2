package org.tarea2;
import org.junit.jupiter.api.AfterEach;
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
    void setUp() throws OverflowEnumException, EmpleadoNullException {
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
    @DisplayName("Test para evaluar tipo correcto de reunión")
    void tipoReunion() {
        assertEquals(TipoReunion.values()[1], reunion.getTipoReunion());
        assertThrows(OverflowEnumException.class, () -> {
            new ReunionPresencial(10, new Date(), Instant.now(), Duration.ofHours(1), new ArrayList<>(), "Sala 1");
        });
    }
    @Test
    @DisplayName("Test para obtener asistencias")
    void obtenerAsistencias() throws EmpleadoNoInvitadoException, ReunionYaFinalizoException, IniciarReunionIniciadaException {
        reunion.empleadoEntrando(empleado1);
        reunion.empleadoEntrando(empleado2);
        reunion.iniciar();
        reunion.empleadoEntrando(empleado3);
        assertEquals(3, reunion.obtenerAsistencias().size());
    }

    @Test
    @DisplayName("Test para obtener retrasos")
    void obtenerRetrasos() throws IniciarReunionIniciadaException, EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        reunion.empleadoEntrando(empleado3);
        reunion.iniciar();
        reunion.empleadoEntrando(empleado1);
        reunion.empleadoEntrando(empleado2);
        assertEquals(2, reunion.obtenerRetrasos().size());
    }

    @Test
    @DisplayName("Test para obtener ausencias")
    void obtenerAusencias() throws IniciarReunionIniciadaException, EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        reunion.empleadoEntrando(empleado1);
        reunion.empleadoEntrando(empleado2);
        reunion.iniciar();
        assertEquals(1, reunion.obtenerAusencias().size());
        reunion.empleadoEntrando(empleado3);
        assertEquals(0, reunion.obtenerAusencias().size());
    }

    @Test
    @DisplayName("Test para obtener un int con el total de asistentes")
    void obtenerTotalAsistencia() throws IniciarReunionIniciadaException, EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        reunion.empleadoEntrando(empleado1);
        reunion.empleadoEntrando(empleado2);
        reunion.iniciar();
        assertEquals(2, reunion.obtenerTotalAsistencia());
    }

    @Test
    void obtenerPorcentajeAsistencia() throws IniciarReunionIniciadaException, EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        reunion.empleadoEntrando(empleado1);
        reunion.iniciar();
        assertEquals(33.33, reunion.obtenerPorcentajeAsistencia(), 0.01);
    }

    @Test
    @DisplayName("Test para Notas")
    void IONota() {
        assertThrows(MensajeNullException.class, () -> {
            reunion.nuevaNota(null);
        });
    }

    @Test
    @DisplayName("Test para empleado no invitado entrando a la reunión")
    void empleadoNoInvitado() {
        assertThrows(EmpleadoNoInvitadoException.class, () -> {
            reunion.empleadoEntrando(new Empleado("4", "Gabriel", "Castillo", "gcastillo@udec.cl"));
        });
    }

    @Test
    @DisplayName("Test para empleado entrando a una reunión ya finalizada")
    void empleadoEntrandoReunionFinalizada() throws IniciarReunionIniciadaException, FinalizarReunionNoIniciadaException {
        reunion.iniciar();
        reunion.finalizar();
        assertThrows(ReunionYaFinalizoException.class, () -> {
            reunion.empleadoEntrando(empleado1);
        });
    }

    @Test
    @DisplayName("Test para duración de una reunión")
    void duracionReunion(){
        assertThrows(DuracionNullException.class, () ->{
           reunion.calcularTiempoReal();
        });
    }

    @Test
    @DisplayName("Test para iniciar una reunión")
    void iniciarReunion(){
        assertDoesNotThrow(() -> {
            reunion.iniciar();
        });
        assertThrows(IniciarReunionIniciadaException.class, () -> {
            reunion.iniciar();
        });
    }

    @Test
    @DisplayName("Test para finalizar una reunión")
    void finalizarReunion() throws IniciarReunionIniciadaException {
        assertThrows(FinalizarReunionNoIniciadaException.class, () -> {
            reunion.finalizar();
        });
        reunion.iniciar();
        assertDoesNotThrow(() -> {
            reunion.finalizar();
        });
    }

    @AfterEach
    void tearDown() {
        reunion = null;
        listaInvitados = null;
        empleado1 = null;
        empleado2 = null;
        empleado3 = null;
    }
}