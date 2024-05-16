package org.tarea2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {

    @Test
    @DisplayName("Comprobando dos casos de empleados para enviar invitación.")
    void enviarInvitacion() {
        Empleado empleado1 = new Empleado("1", "Juan", "Perez", "jperes@udec.cl");
        Invitacion invitacion = new Invitacion();

        assertThrows(EmpleadoNullException.class, () -> {
            invitacion.enviarInvitacion(null);
        });
        assertDoesNotThrow(() -> {
            invitacion.enviarInvitacion(empleado1);
        });
    }
}