package org.tarea2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartamentoTest {
    private Departamento departamento;
    @BeforeEach
    void setUp() {
        Departamento departamento = new Departamento("Departamento de Pruebas");
    }


    @Test
    void addEmpleado() {
        Empleado Juan = new Empleado("1", "Juan", "Perez", "correojuan@ubb.cl");
        departamento.addEmpleado(Juan);
        assertEquals(1, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void addEmpleado2(){
        Empleado Juan = new Empleado("1", "Juan", "Perez", "correojuan@ubb.cl");
        Empleado Marcos = new Empleado("2", "Marcos", "Martinez", "mamartinez2023@inacap.cl");
        Empleado Gabriel = new Empleado("3", "Gabriel", "Castillo", "gacastillo2023@duoc.cl");
        assertEquals(3,departamento.obtenerCantidadEmpleados());
    }

}
