/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Labing
 */
public class Habitacion {

    private int NumHabitacion;
    private int CapMaxOcupacion;
    private double precio;
    private int NumPiso;

    public Habitacion(int NumHabitacion, int CapMaxOcupacion, double precio, int NumPiso) {
        this.NumHabitacion = NumHabitacion;
        this.CapMaxOcupacion = CapMaxOcupacion;
        this.precio = precio;
        this.NumPiso = NumPiso;
    }

    public int getNumHabitacion() {
        return NumHabitacion;
    }

    public void setNumHabitacion(int NumHabitacion) {
        this.NumHabitacion = NumHabitacion;
    }

    public int getCapMaxOcupacion() {
        return CapMaxOcupacion;
    }

    public void setCapMaxOcupacion(int CapMaxOcupacion) {
        this.CapMaxOcupacion = CapMaxOcupacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumPiso() {
        return NumPiso;
    }

    public void setNumPiso(int NumPiso) {
        this.NumPiso = NumPiso;
    }

    
    
}
