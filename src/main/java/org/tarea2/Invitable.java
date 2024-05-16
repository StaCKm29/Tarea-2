package org.tarea2;
/**
 * Interfaz que invita a cualquier clase que implemente la interfaz (Empleado y Departamento) a una reunión.
 */
public interface Invitable {
    /**
     * Enviar la invitacion con una hora predeterminada.
     * @param hora Hora de la invitación.
     */
    void invitar(String hora);
}
