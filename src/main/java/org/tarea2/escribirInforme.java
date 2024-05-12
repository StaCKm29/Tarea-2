package org.tarea2;
import java.io.*;
public class escribirInforme {
    public void generarInforme(Reunion reunion){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("InformeReunion.txt"));
            writer.write("Informe de la reunion");
            writer.newLine();
            writer.write("Fecha y hora de la reunión: " + reunion.getFecha() + " " + reunion.getHoraPrevista());
            writer.newLine();
            writer.write("Hora de inicio de la reunión: " + reunion.getHoraInicio());
            writer.newLine();
            writer.write("Hora de fin de la reunión: " + reunion.getHoraFin());
            writer.newLine();
            writer.write("Duración total de la reunión: " + reunion.calcularTiempoReal());
            writer.newLine();
            writer.write("Tipo de reunión: " + reunion.getTipoReunion());
            writer.newLine();
            writer.write("Enlace o sala: " + reunion.getEnlaceOSala());
            writer.newLine();
            writer.write("Lista de participantes: " + reunion.getListaInvitados());
            writer.newLine();
            writer.write("Notas relacionadas con la reunión: ");
            for (Nota nota : reunion.getAlmacenNotas()) {
                writer.write(nota.getMensaje());
                writer.newLine();
            }

            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
