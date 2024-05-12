package org.tarea2;
import java.io.*;
public class escribirInforme {
    private String nombreArchivo;
    public void generarInforme(Reunion reunion){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo + ".txt"));
            writer.write("Informe de la reunion");
            writer.newLine();
            writer.write("Fecha y hora de la reunión: " + reunion.getFecha() + " " + reunion.getHoraPrevista());
            writer.newLine();
            writer.write("El tipo de reunión fue: " + reunion.getTipoReunion());
            writer.newLine();
            writer.write(reunion.getSalaEnlace());
            writer.newLine();
            writer.write("Lista de Participantes: ");
            writer.newLine();
            for (Object empleado : reunion.obtenerAsistencias()){
                writer.write(">> ");
                writer.write(empleado.toString());
                writer.newLine();
            }
            writer.write("Notas relacionadas a la reunión: ");
            writer.newLine();
            writer.write(reunion.getNotas());
            writer.close();
            System.out.println("Se ha creado el archivo correctamente.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public escribirInforme(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }
}
