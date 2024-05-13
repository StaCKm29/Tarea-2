package org.tarea2;
import java.io.*;
import java.time.Duration;
import java.util.List;

/*
    * Clase que se encarga de escribir un informe de la reunión en un archivo de texto.
 */
public class EscribirInforme {
    private String nombreArchivo;

    /**
     * Método que genera un archivo de texto con el informe de la reunión.
     * @param reunion Reunión de la que se generará el informe.
     */
    public void generarInforme(Reunion reunion){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo + ".txt"));
            writer.write("Informe de la reunión\n");
            writer.newLine();
            writer.write("Fecha y hora de la reunión: " + reunion.getFecha() + " " + reunion.getHoraPrevista());
            writer.newLine();
            writer.write("El tipo de reunión fue: " + reunion.getTipoReunion());
            writer.newLine();
            writer.write(reunion.getSalaEnlace()+"\n");
            writer.newLine();
            writer.write("Lista de Participantes: ");
            writer.newLine();
            for (Object empleado : reunion.obtenerAsistencias()){
                writer.write(">> ");
                writer.write(empleado.toString());
                writer.newLine();
            }
            writer.write("Lista de empleados que llegaron atrasados: ");
            writer.newLine();
            for(Retraso retraso : reunion.getEmpleadosHoraRetraso()){
                writer.write(">> ");
                writer.write(retraso.getEmpleado().toString());
                writer.write(" con un retraso de ");
                Duration duracion = retraso.getTiempoAtraso();
                writer.write(String.format("%02d:%02d:%02d", duracion.toHoursPart(), duracion.toMinutesPart(), duracion.toSecondsPart()));
                writer.newLine();
            }
            writer.write("\n");
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
    /**
     * Constructor de la clase EscribirInforme
     * @param nombreArchivo Nombre del archivo en el que se guardará el informe.
     */
    public EscribirInforme(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }
}
