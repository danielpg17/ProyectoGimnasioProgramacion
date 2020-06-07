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
public class Mantenimiento extends Trabajador {
    
    private int aServicio;
    
    /**
     * Variables de la clase Mantenimiento.
     * @param dni
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param aServicio 
     */
    
    /*Constructor de la clase Mantenimiento*/

    public Mantenimiento(String dni, String nombre, String apellido, String email, int telefono, int aServicio) {
        
        super(dni, nombre, apellido, email, telefono);
        this.aServicio = aServicio;
    }

    /*Getters y Setters*/
    public int getaServicio() {
        return aServicio;
    }
    
    /**
     * 
     * @param aServicio 
     */
    public void setaServicio(int aServicio) {
        this.aServicio = aServicio;
    }
    
    /*To String de la clase Mantenimiento*/

    @Override
    public String toString() {
        return " Dni= " + this.getDni() + "\n Nombre= " + this.getNombre() + "\n Apellido= " + this.getApellido() + "\n Email= " + this.getEmail() + "\n Telefono= " + this.getTelefono()+"\n Años de Servicio: " + this.aServicio;
    }

    
    
    
    
    
}
