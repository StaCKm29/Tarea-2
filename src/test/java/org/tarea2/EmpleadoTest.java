package org.tarea2;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class EmpleadoTest {
    private Empleado empleado;
    @BeforeEach
    public void setUp() {
        empleado = new Empleado("1", "Juan", "Perez", "juperez@udec.cl");
    }

    @Test
    @DisplayName("Test la clase Empleado")
    public void testEmpleado() {
        assertNotNull(empleado);
        assertEquals("1", empleado.getId());
        assertEquals("Juan", empleado.getNombre());
        assertEquals("Perez", empleado.getApellidos());
        assertEquals("juperez@udec.cl", empleado.getCorreo());
    }
}
