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
public class Actividad {
    
    private String tipoActividad;
    
    /**
     * Variables de la clase Actividad
     * @param tipoActividad 
     */

    
    /*Constructor de la clase Actividad*/
    
    public Actividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }
    
  /*Getters y Setters*/

    public String getTipoActividad() {
        return tipoActividad;
    }
    
    /**
     * 
     * @param tipoActividad 
     */
    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    
    /*To String de la clase Actividad*/
    @Override
    public String toString() {
        return "Actividad: " + this.tipoActividad;
    }
    
    
    
}
