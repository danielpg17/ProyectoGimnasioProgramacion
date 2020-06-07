/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_gimnasio;

/**
 *
 * @author Daniel
 */
public class Recepcionista extends Trabajador{
    
    private String turno;
    
    /**
     * Variables de la clase recepcionista.
     * @param dni
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param turno 
     */
    
    /*Constructor de la clase Recepcionista*/

    public Recepcionista(String dni, String nombre, String apellido, String email, int telefono, String turno) {
        
        super(dni, nombre, apellido, email, telefono);
        this.turno = turno;
    }
    

    public String getTurno() {
        return turno;
    }

    /**
     * 
     * @param turno 
     */
    
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /*To String de la clase Recepcionista*/
    
    @Override
    public String toString() {
        return " Dni= " + this.getDni() + "\n Nombre= " + this.getNombre() + "\n Apellido= " + this.getApellido() + "\n Email= " + this.getEmail() + "\n Telefono= " + this.getTelefono() +"\n Turno: " + this.turno;
    }
    
    
    
}
