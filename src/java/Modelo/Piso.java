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
public class Piso {

    private int NumPiso ;
    private int NumHabitaciones ;

    public Piso(int NumPiso, int NumHabitaciones) {
        this.NumPiso = NumPiso;
        this.NumHabitaciones = NumHabitaciones;
    }

    public int getNumPiso() {
        return NumPiso;
    }

    public void setNumPiso(int NumPiso) {
        this.NumPiso = NumPiso;
    }

    public int getNumHabitaciones() {
        return NumHabitaciones;
    }

    public void setNumHabitaciones(int NumHabitaciones) {
        this.NumHabitaciones = NumHabitaciones;
    }
    
    
}
