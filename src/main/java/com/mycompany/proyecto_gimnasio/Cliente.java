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
public abstract class Cliente {
    
private String dni;
private String nombre;
private String apellido;
private String email;
private int telefono;

/**
 * Variables de la clase Cliente.
 * Superclase.
 * @param dni
 * @param nombre
 * @param apellido
 * @param email
 * @param telefono 
 */

/*Constructor de la clase Cliente*/

    public Cliente(String dni, String nombre, String apellido, String email, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    /*Getters y Setters*/
    
    public String getDni() {
        return dni;
    }
    
    /**
     * 
     * @param dni 
     */

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }
    
    /**
     * 
     * @param nombre 
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    /**
     * 
     * @param apellido 
     */

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }
    
    /**
     * 
     * @param email 
     */

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }
    
    /**
     * 
     * @param telefono 
     */

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    /*To string de la clase Cliente.*/

 @Override
    public String toString() {
        return "dni= " + dni + "\n nombre= " + nombre + "\n apellido= " + apellido + "\n email= " + email + "\n telefono= " + telefono;
    }

    
}
