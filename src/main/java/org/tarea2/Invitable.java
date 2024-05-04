package org.tarea2;
import java.time.Instant;
/**
 * Interfaz para invitar a un empleado a un evento
 */
public interface Invitable {
    /**
     * Invita a un empleado a un evento
     */
    public void invitar(Instant hora);
}
