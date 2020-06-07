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
public class Invitado extends Cliente{
    
    private int nInvitado;
    private boolean prueba;
    
    /**
     * Variables de la clase Invitado.
     * @param dni
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param nInvitado
     * @param prueba 
     */
    
    /*Constructor de la clase Invitado*/

    public Invitado(String dni, String nombre, String apellido, String email, int telefono, int nInvitado, boolean prueba) {
        
        super(dni, nombre, apellido, email, telefono);
        
        this.nInvitado = nInvitado;
        this.prueba = prueba;
    }
    
    /*Getters y Setters*/

    public int getnInvitado() {
        return nInvitado;
    }
    
    /**
     * 
     * @param nInvitado 
     */

    public void setnInvitado(int nInvitado) {
        this.nInvitado = nInvitado;
    }

    public boolean isPrueba() {
        return prueba;
    }
    
    /**
     * 
     * @param prueba 
     */

    public void setPrueba(boolean prueba) {
        this.prueba = prueba;
    }
    
    /*To String de la clase Invitado*/
    
    @Override
    public String toString() {
        return " dni= " + this.getDni() + "\n nombre= " + this.getNombre() + "\n apellido= " + this.getApellido() + "\n email= " + this.getEmail() + "\n telefono= " + this.getTelefono() + "\n nInvitado= " + this.nInvitado + "\n prueba= " + this.prueba;
    }
    
    
}
