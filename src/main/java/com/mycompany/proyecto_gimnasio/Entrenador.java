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
public class Entrenador extends Trabajador{
    
    private int nclientes;
    private String nombreCliente;
    
    /**
     * Variables de la clase Entrenador.
     * @param dni
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param nclientes
     * @param nombreCliente 
     */

    /*Constructor de la clase Entrenador*/
    
    public Entrenador(String dni, String nombre, String apellido, String email, int telefono, int nclientes, String nombreCliente) {
        
        super(dni, nombre,apellido,email,telefono);
        this.nclientes = nclientes;
        this.nombreCliente = nombreCliente;
    }
    
    /*Getters y Setters*/

    public int getNclientes() {
        return nclientes;
    }
    
    /**
     * 
     * @param nclientes 
     */

    public void setNclientes(int nclientes) {
        this.nclientes = nclientes;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    /**
     * 
     * @param nombreCliente 
     */

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    /*To String de la clase Trabajadors*/

    @Override
    public String toString() {
        return " dni= " + this.getDni() + "\n nombre= " + this.getNombre() + "\n apellido= " + this.getApellido() + "\n email= " + this.getEmail() + "\n telefono= " + this.getTelefono() + "\n nclientes= " + this.nclientes + "\n nombreCliente= " + this.nombreCliente;
    }
    
    
    
    
}
