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
public class Socio extends Cliente{
    
  private int nsocio;
  
  /**
   * Variables de la clase Socio.
   * @param dni
   * @param nombre
   * @param apellido
   * @param email
   * @param telefono
   * @param nsocio 
   */
  
  /*Constructor de la clase socio*/

    public Socio(String dni, String nombre, String apellido, String email, int telefono, int nsocio) {
        
        super(dni, nombre, apellido, email, telefono);
        
        this.nsocio = nsocio;
    }
    
    /*Getters y Setters*/

    public int getNsocio() {
        return nsocio;
    }

    /**
     * 
     * @param nsocio 
     */
    
    public void setNsocio(int nsocio) {
        this.nsocio = nsocio;
    }
    
    /*To string de la clase socio*/

@Override
    public String toString() {
        return " dni= " + this.getDni() + "\n nombre= " + this.getNombre() + "\n apellido= " + this.getApellido() + "\n email= " + this.getEmail() + "\n telefono= " + this.getTelefono() + "\n nSocio= " + nsocio;
    }
  
  
}
