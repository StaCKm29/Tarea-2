package org.tarea2;
import java.io.*;
public class escribirInforme {
    public void generarInforme(Reunion reunion){
        try{
            FileWriter writer = new FileWriter("Informe.txt");
            writer.write("Informe de la reunion");
            writer.write("Fecha y hora de la reunión: " + reunion.getFecha() + " " + reunion.getHoraPrevista());
            writer.write("El tipo de reunión fue: " + reunion.getTipoReunion());
            writer.write(reunion.getSalaEnlace());
            writer.write("Lista de Participantes: ");
            for (Object empleado : reunion.obtenerAsistencias()){
                writer.write(empleado.toString());
            }
            writer.write("Notas relacionadas a la reunión: ");
            writer.write(reunion.getNotas());
            writer.close();
            System.out.println("Se ha creado el archivo correctamente.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
