package org.tarea2;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author : Gabriel Castillo
 * @author : Marcos Martínez
 * @version : 1.0
 */

public class Main {
    public static void main(String[] args) throws EmpleadoNullException, MensajeNullException, DuracionNullException, IniciarReunionIniciadaException, FinalizarReunionNoIniciadaException, OverflowEnumException, EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        // Crear un objeto Date con año, mes y día
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        Date fecha = calendar.getTime();
        // Crear un objeto LocalDateTime con hora y minuto
        LocalDateTime hora = LocalDateTime.of(2024, Month.MAY, 15, 10, 30); // Año, Mes, Día, Hora, Minutos
        // Convertir LocalDateTime a Instant
        Instant horaPrevista = hora.atZone(ZoneId.systemDefault()).toInstant();
        Duration duracionPrevista = Duration.ofHours(1).plusMinutes(30);

        // Crear una lista de empleados los cuales serán invitados a la reunión
        List<Empleado> listaInvitados = new ArrayList<>();
        Empleado empleado1 = new Empleado("1", "Juan", "Perez", "jperez@udec.cl");
        listaInvitados.add(empleado1);
        Empleado empleado2 = new Empleado("2", "María", "López", "mlopez@udec.cl");
        listaInvitados.add(empleado2);
        Empleado empleado3 = new Empleado("3", "Pedro", "González", "pgonzalez@udec.cl");
        listaInvitados.add(empleado3);
        Empleado empleado4 = new Empleado("4", "Ana", "Martínez", "amartinez@udec.cl");
        listaInvitados.add(empleado4);
        Empleado empleado5 = new Empleado("5", "Luis", "Rodríguez", "lrodriguez@udec.cl");
        listaInvitados.add(empleado5);
        //Agregando un empleado nulo a la lista de invitados
        Empleado empleadonulo = null;
        listaInvitados.add(empleadonulo);
        //Creando un empleado no invitado a la reunión
        Empleado noInvitado = new Empleado("6", "José", "Fuentes", "jfuentes@udec.cl");
        //Creando un empleado que llegará al finalizar la reunión
        Empleado superAtrasado = new Empleado("7", "Gabriel", "Castillo", "gcastillo@udec.cl");
        listaInvitados.add(superAtrasado);

        //Invitando un empleado null a la reunión.
        try {
            Reunion reunion = new ReunionPresencial(2, fecha, horaPrevista, duracionPrevista, listaInvitados, "Sala 1");
        }catch (OverflowEnumException e){
            System.out.println("Error, el tipo de reunión debe estar entre 0 y 2.");
        }catch (EmpleadoNullException e){
            System.out.println("Error, el empleado es nulo");
        }
        System.out.println();

        listaInvitados.remove(empleadonulo);
        //Intentando finalizar una reunión que no ha sido iniciada
        Reunion reunion = new ReunionPresencial(1, fecha, horaPrevista, duracionPrevista, listaInvitados, "Sala 1");
        try{
            reunion.finalizar();
        }
        catch (FinalizarReunionNoIniciadaException e){
            System.out.println("No se puede finalizar una reunión que no ha sido iniciada");
        }

        //Calculando tiempo antes de haber finalizado la reunión
        reunion.empleadoEntrando(empleado1);
        reunion.iniciar();
        try{
            reunion.calcularTiempoReal();
        }
        catch (DuracionNullException e){
            System.out.println("Error, la reunion no ha sido finalizada");
        }

        //Iniciando la reunión una segunda vez
        try{
            reunion.iniciar();
        }
        catch (IniciarReunionIniciadaException e){
            System.out.println("No se puede iniciar una reunión ya iniciada");
        }
        try{
            reunion.empleadoEntrando(noInvitado);
        }  catch(EmpleadoNoInvitadoException e){
            System.out.println("Error, el empleado no ha sido invitado a esta reunión");
        } catch(ReunionYaFinalizoException e){
            System.out.println("Error, la reunión ya finalizó");
        }

        //Agregando notas a la reunión
        reunion.nuevaNota("Nota 1");
        reunion.nuevaNota("Nota 2");
        reunion.nuevaNota("Nota 3");

        //Empleados atrasados entrando a la reunión
        reunion.empleadoEntrando(empleado2);
        reunion.empleadoEntrando(empleado3);

        //Creamos una reunion simulada de 10 segundos
        try {
            TimeUnit.SECONDS.sleep(10); // Retraso de 10 segundos
        } catch (InterruptedException e) {
            // Manejar la interrupción
        }

        reunion.finalizar();
        //Entrando un empleado a una reunion ya finalizada.
        try{
            reunion.empleadoEntrando(superAtrasado);
        } catch(EmpleadoNoInvitadoException e){
            System.out.println("Error, el empleado no ha sido invitado a esta reunión");
        }
        catch (ReunionYaFinalizoException e){
            System.out.println("Error, la reunión ya finalizó");
        }
        System.out.println();



        //Reunión ya finalizada e imprimimos por terminal todos los métodos que tenga la reunión.

        EscribirInforme informe = new EscribirInforme("InformeReunion");
        informe.generarInforme(reunion);
        System.out.println();

        System.out.println("Organizador de la reunión: " + reunion.getOrganizador());
        System.out.println();

        //Pasar de tiempo en formato Duration a formato LocalTime
        Duration duracion = reunion.calcularTiempoReal();
        long horas = duracion.toHours();
        long minutos = duracion.toMinutesPart();
        long segundos = duracion.toSecondsPart();
        // Creamos un objeto LocalTime con los componentes obtenidos
        LocalTime tiempo = LocalTime.of((int) horas, (int) minutos, (int) segundos);
        System.out.println("Duración de la reunión: " + tiempo.toString());
        System.out.println();

        System.out.println("Empleados que asistieron a la reunión: ");
        for (Object em : reunion.obtenerAsistencias())
            System.out.println(em);
        System.out.println();

        System.out.println("Empleados que llegaron tarde a la reunión: ");
        for (Object em : reunion.obtenerRetrasos())
            System.out.println(em);
        System.out.println();

        System.out.println("Empleados que no asistieron a la reunión: ");
        for (Object em : reunion.obtenerAusencias())
            System.out.println(em);
        System.out.println();

        System.out.println("Cantidad de empleados que asistieron a la reunión: " + reunion.obtenerTotalAsistencia());
        System.out.println();

        System.out.println("Porcentaje de asistencia a la reunión: " + reunion.obtenerPorcentajeAsistencia()+"%");
        System.out.println();

        System.out.println("Notas de la reunión: " + reunion.getNotas());
        System.out.println();
        System.out.println();



        //OTRA REUNIÓN DISTINTA CON UNA INVITACIóN A UN DEPARTAMENTO.
        System.out.println("REUNION 2");
        System.out.println();
        Empleado em1 = new Empleado("6", "José", "Fuentes", "jfuentes@udec.cl");
        Empleado em2 = new Empleado("7", "Geoffrey", "Hecht", "ghecht@udec.cl");
        Empleado em3 = new Empleado("8", "Pierluigi", "Cerulo", "pcerulo@udec.cl");


        //Creación de un departamento.
        Departamento DIICC = new Departamento("DIICC");
        //Agrgando empleados al departamento
        DIICC.addEmpleado(em1);
        DIICC.addEmpleado(em2);
        DIICC.addEmpleado(em3);


        //Invitamos a todo el departamento a la reunion 2.
        Reunion reunion2 = new ReunionVirtual(0, fecha, horaPrevista, duracionPrevista, DIICC.getEmpleados(), "https://meet.google.com/abc-123-def");

        reunion2.empleadoEntrando(em1);
        reunion2.empleadoEntrando(em2);
        reunion2.empleadoEntrando(em3);

        reunion2.nuevaNota("Nota 1");

        //Agregar una nota nula
        try{
            reunion2.nuevaNota(null);
        }
        catch (MensajeNullException e){
            System.out.println("Mensaje nulo");
        }

        reunion2.iniciar();
        reunion2.finalizar();

        //Imprimir algunos métodos de la reunion 2
        System.out.println("Cantidad de empleados en reunion 2: " + reunion.obtenerTotalAsistencia());
        System.out.println("Empleados que llegaron a tiempo a la reunion 2: ");
        for(Object em : reunion2.obtenerAsistencias())
            System.out.println(em);

        System.out.println();
        System.out.println("TERCERA REUNIÓN");

        //Creación de una tercera reunión con un tipo de reunión no válido.
        try {
            Reunion reunion3 = new ReunionPresencial(4, fecha, horaPrevista, duracionPrevista, listaInvitados, "Sala 2");
        }catch (OverflowEnumException e){
            System.out.println("Error, el tipo de reunión debe estar entre 0 y 2.");
        }catch (EmpleadoNullException e){
            System.out.println("Error, el empleado es nulo");
        }
    }
}
