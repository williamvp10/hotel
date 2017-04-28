/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Labing
 */
public class Registro {

    private int id;
    private int NumHabitacion;
    private Date fechaInicio;
    private Date fechaSalida;
    private Persona Responsable;

    public Registro(int id, int NumHabitacion, Date fechaInicio, Date fechaSalida, Persona Responsable) {
        this.id = id;
        this.NumHabitacion = NumHabitacion;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
        this.Responsable = Responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumHabitacion() {
        return NumHabitacion;
    }

    public void setNumHabitacion(int NumHabitacion) {
        this.NumHabitacion = NumHabitacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Persona getResponsable() {
        return Responsable;
    }

    public void setResponsable(Persona Responsable) {
        this.Responsable = Responsable;
    }
    
    
}
