package org.tarea2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Instant;
import java.util.List;

public class AsistenciaTest {
    private Asistencia asistencia;
    private Empleado Juan;
    private Empleado Marcos;
    private Empleado Gabriel;
    private Instant inicio;
    @BeforeEach
    void setUp() {
        Empleado Juan = new Empleado("1", "Juan", "Perez", "correojuan@ubb.cl");
        Empleado Marcos = new Empleado("2", "Marcos", "Martinez", "mamartinez2023@inacap.cl");
        Empleado Gabriel = new Empleado("3", "Gabriel", "Castillo", "gacastillo2023@duoc.cl");
        List<Empleado> empleados = List.of(Juan, Marcos, Gabriel);
        Asistencia asistencia = new Asistencia(empleados);
        Instant inicio = Instant.now();
    }

    @Test
    void addAsistente() {
        asistencia.addAsistente(Gabriel, inicio, Instant.now());
        assertEquals(Gabriel, asistencia.getPresentes().get(0));
    }

    @Test
    void addAsistente2() {
        asistencia.addAsistente(Marcos, inicio, Instant.now());
    }

    @Test
    void encontrarAusetes() {
    }
}
