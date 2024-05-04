package org.tarea2;

import java.awt.event.WindowStateListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Asistencia {
    private List<Empleado> empleados;
    private List<Empleado> presentes;
    private List<Empleado> atrasados;
    private List<Empleado> ausentes;
    private List<Instant> horaDeAtraso;

    public Asistencia(List empleados){
        this.empleados = empleados;
        this.atrasados = new ArrayList<>();
        this.horaDeAtraso = new ArrayList<>();
        for(int i = 0; i < empleados.size(); i++ ){
            horaDeAtraso.add(null);
        }
        this.ausentes = new ArrayList<>();
        this.presentes = new ArrayList<>();
    }

    public void addAsistente(Empleado juan, Instant inicio, Instant llegada){
        int comparacion = llegada.compareTo(inicio);
        if(comparacion > 0){
            horaDeAtraso.set(empleados.indexOf(juan), llegada);
            atrasados.add(juan);
            presentes.add(juan);
        }
        else{
            presentes.add(juan);
        }
    }

    public void encontrarAusetes(){
        for(Empleado elemento : empleados ){
            if(presentes.contains(elemento)){}
            else{
                ausentes.add(elemento);
            }
        }
    }

    public List getPresentes(){
        return presentes;
    }

    public List getAtrasados(){
        return atrasados;
    }

    public List getAusentes(){
        return ausentes;
    }

}
